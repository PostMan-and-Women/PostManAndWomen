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

    /**
     * 댓글 추가
     */
    @Transactional
    public ResponseDto<?> registerComment(Long postId, CommentRequestDto CommentRequestDto, Account account) {
        postIdCheck(postId);

        String content = CommentRequestDto.getContent();

        Optional<Post> findPost = postRepository.findById(postId);

        if(findPost.isEmpty()) {
            return ResponseDto.fail(HttpStatus.NOT_FOUND, "해당 댓글이 존재하지 않습니다.");
        }

        Comment savedComment = commentRepository.save(new Comment(findPost.get(), content, account));
        CommentResponseDto commentResponseDto = new CommentResponseDto(savedComment);

        return ResponseDto.success(commentResponseDto);
    }

    /**
     * 댓글 전체 조회
     */
    public ResponseDto<?> findAllComments(Long postId) {

        postIdCheck(postId);

        List<Comment> findAllComment = commentRepository.findAllByPostId(postId);
        List<CommentResponseDto> comments = new ArrayList<>();

        for (Comment savedComment : findAllComment) {
            comments.add(new CommentResponseDto(savedComment));
        }
        return ResponseDto.success(comments);
    }

    /**
     * 댓글 삭제
     */
    @Transactional
    public ResponseDto<?> removeComment(Long postId, Long commentId) {
        Optional<Comment> findComment = commentRepository.findById(commentId);

        postIdCheck(postId);
        commentIdCheck(findComment);

        commentRepository.deleteById(commentId);
        return ResponseDto.success("삭제 완료");
    }

    /**
     * 댓글 수정
     */
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

    /**
     * 댓글 수정/삭제 시 댓글 유무 확인
     * @param findComment
     */
    private void commentIdCheck(Optional<Comment> findComment) {
        if(findComment.isEmpty()) {
            throw new RequestException(HttpStatus.NOT_FOUND, "해당 댓글이 존재하지 않습니다.");
        }
    }

    /**
     * 댓글 추가/수정/삭제/조회 시 게시물 유무 확인
     */
    private void postIdCheck(Long id) {
        postRepository.findById(id).orElseThrow(
                () -> new RequestException(HttpStatus.NOT_FOUND,"해당 게시글이 존재하지 않습니다.")
        );
    }

}