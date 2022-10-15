// CommentService.class
package com.example.postmanandwomen.service;

import com.example.postmanandwomen.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CommentService {

    private final CommentRepository commentRepository;

//    @Transactional
//    public ResponseDto registerComment(Long boardId, CommentRequestDto CommentRequestDto) {
//        String content = CommentRequestDto.getContent();
//
//        Post findPost = PostRepository.findById(boardId).orElseThrow(
//                () -> new IllegalArgumentException("존재하지 않는 게시물입니다.")
//        );
//
//        Comment savedComment = commentRepository.save(new Comment(boardId, content)); // boardId,
//
//        return ResponseDto.success(savedComment);
//
//    }
//
//
//    public ResponseDto findAllComments(Long boardID) {
//        List<Comment> findAllComment = commentRepository.findAllByBoardId(boardID);
//        List<CommentResponseDto.CommentRegisterResponseDto> comments = new ArrayList<>();
//
//        for (Comment savedComment : findAllComment) {
//            if(savedComment.getBoard().getId() == (boardID)) {
//                comments.add(new CommentResponseDto.CommentRegisterResponseDto(savedComment));
//            }
//        }
//        return comments;
//    }
//
//    @Transactional
//    public ResponseDto removeComment(Long commentId) {
//        Optional<Comment> findComment = commentRepository.findById(commentId);
//        commentRepository.delete(findComment.orElseThrow(
//                () -> new IllegalArgumentException("존재하지 않는 댓글입니다.")
//        ));
//
//        return findComment.get().getId();
//    }
//
//    @Transactional
//    public ResponseDto modifyComment(Long commentId, CommentRequestDto commentRequestDto) {
//        Comment comment = commentRepository.findById(commentId).orElseThrow(
//                () -> new IllegalArgumentException("존재하지 않는 댓글입니다.")
//        );
//        comment.updateComment(commentRegisterRequestDto.getContent());
//
//        return new CommentResponseDto.CommentRegisterResponseDto(comment);
//    }

}