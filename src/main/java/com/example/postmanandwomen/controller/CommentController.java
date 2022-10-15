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

    @PostMapping("/auth/comment/{id}")
    public ResponseDto postComment(@PathVariable Long id,
                                   @RequestBody CommentRequestDto commentRequestDto,
                                   @AuthenticationPrincipal UserDetailsImpl userDetails) {
        System.out.println("CommentController.postComment");
        return commentService.registerComment(id, commentRequestDto, userDetails.getAccount());
    }

    @GetMapping("/comment/{id}")
    public ResponseDto<?> getComments(@PathVariable Long id) {
        return commentService.findAllComments(id);
    }

//    @DeleteMapping("/auth/comment/{id}")
//    public ResponseDto deleteComment(@PathVariable Long id) {
//        return commentService.removeComment(id);
//    }
//
//    @PatchMapping("/auth/comment/{id}")
//    public ResponseDto editComment(@PathVariable Long id,
//                                   @RequestBody CommentRequestDto commentRequestDto) {
//        return commentService.modifyComment(id, commentRequestDto);
//    }

}