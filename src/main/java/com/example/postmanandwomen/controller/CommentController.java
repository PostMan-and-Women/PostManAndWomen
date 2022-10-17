package com.example.postmanandwomen.controller;

import com.example.postmanandwomen.dto.CommentRequestDto;
import com.example.postmanandwomen.dto.ResponseDto;
import com.example.postmanandwomen.security.user.UserDetailsImpl;
import com.example.postmanandwomen.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    /**
     * 댓글 작성
     */
    @PostMapping("/auth/comment/{postId}")
    public ResponseDto postComment(@PathVariable Long postId,
                                   @RequestBody CommentRequestDto commentRequestDto,
                                   @AuthenticationPrincipal UserDetailsImpl userDetails) {
        System.out.println("CommentController.postComment");
        return commentService.registerComment(postId, commentRequestDto, userDetails.getAccount());
    }

    /**
     * 댓글 전체 조회
     */
    @GetMapping("/comment/{postId}")
    public ResponseDto<?> getComments(@PathVariable Long postId) {
        return commentService.findAllComments(postId);
    }

    /**
     * 댓글 삭제
     * @param postId
     * @param commentId
     */
    @DeleteMapping("/auth/comment/{postId}/{commentId}")
    public ResponseDto deleteComment(@PathVariable Long postId, @PathVariable Long commentId) {
        return commentService.removeComment(postId, commentId);
    }

    /**
     * 댓글 수정
     * @param postId
     * @param commentId
     */
    @PatchMapping("/auth/comment/{postId}/{commentId}")
    public ResponseDto editComment(@PathVariable Long postId, @PathVariable Long commentId,
                                   @RequestBody CommentRequestDto commentRequestDto) {
        return commentService.modifyComment(postId, commentId, commentRequestDto);
    }

}