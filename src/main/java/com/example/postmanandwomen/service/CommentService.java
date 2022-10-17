// CommentService.class
package com.example.postmanandwomen.service;

import com.example.postmanandwomen.dto.CommentRequestDto;
import com.example.postmanandwomen.dto.CommentResponseDto;
import com.example.postmanandwomen.dto.ResponseDto;
import com.example.postmanandwomen.entity.Account;
import com.example.postmanandwomen.entity.Comment;
import com.example.postmanandwomen.entity.Post;
import com.example.postmanandwomen.exception.RequestException;
import com.example.postmanandwomen.repository.CommentRepository;
import com.example.postmanandwomen.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CommentService {

    private final CommentRepository commentRepository;
    private final PostRepository postRepository;

    @Transactional
    public ResponseDto<?> registerComment(Long postId, CommentRequestDto CommentRequestDto, Account account) {
        String content = CommentRequestDto.getContent();

        /* findAllComments 에도 동일한 코드 */
        /* 리펙토링 대상 */
        Optional<Post> findPost = postRepository.findById(postId);

        if(findPost.isEmpty()) {
            return ResponseDto.fail(HttpStatus.NOT_FOUND, "해당 댓글이 존재하지 않습니다.");
        }

        Comment savedComment = commentRepository.save(new Comment(findPost.get(), content, account));
        CommentResponseDto commentResponseDto = new CommentResponseDto(savedComment);

        return ResponseDto.success(commentResponseDto);
    }

    public ResponseDto<?> findAllComments(Long postId) {

        postIdCheck(postId);

        List<Comment> findAllComment = commentRepository.findAllByPostId(postId);
        List<CommentResponseDto> comments = new ArrayList<>();

        for (Comment savedComment : findAllComment) {
            comments.add(new CommentResponseDto(savedComment));
        }
        return ResponseDto.success(comments);
    }

    @Transactional
    public ResponseDto<?> removeComment(Long postId, Long commentId) {
        Optional<Comment> findComment = commentRepository.findById(commentId);

        postIdCheck(postId);
        commentIdCheck(findComment);

        commentRepository.deleteById(commentId);
        return ResponseDto.success("삭제 완료");
    }

    @Transactional
    public ResponseDto<?> modifyComment(Long postId, Long commentId,
                                     CommentRequestDto commentRequestDto) {
        Optional<Comment> findComment = commentRepository.findById(commentId);

        postIdCheck(postId);

        commentIdCheck(findComment);
        Comment comment = findComment.get();
        comment.updateComment(commentRequestDto.getContent());
        commentRepository.save(comment);

        return ResponseDto.success(new CommentResponseDto(findComment.get()));
    }

    private void commentIdCheck(Optional<Comment> findComment) {
        if(findComment.isEmpty()) {
            throw new RequestException(HttpStatus.NOT_FOUND, "해당 댓글이 존재하지 않습니다.");
        }
    }

    private void postIdCheck(Long id) {
        postRepository.findById(id).orElseThrow(
                () -> new RequestException(HttpStatus.NOT_FOUND,"해당 게시글이 존재하지 않습니다.")
        );
    }

}