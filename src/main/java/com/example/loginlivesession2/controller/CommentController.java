// CommentController.java
package com.example.loginlivesession2.controller;


import com.example.loginlivesession2.dto.CommentRequestDto;
import com.example.loginlivesession2.dto.ResponseDto;
import com.example.loginlivesession2.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;
//
//    @PostMapping("/auth/comment/{id}")
//    public ResponseDto postComment(@PathVariable Long id,
//                                   @RequestBody CommentRequestDto commentRequestDto) {
//        return commentService.registerComment(id, commentRequestDto);
//    }
//
//    @GetMapping("comment")
//    public ResponseDto<?> getComments(@PathVariable Long id) {
//        return commentService.findAllComments(id);
//    }
//
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