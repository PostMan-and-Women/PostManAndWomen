package com.example.loginlivesession2.controller;

import com.example.loginlivesession2.dto.LikesRequestDto;
import com.example.loginlivesession2.dto.LikesResponseDto;
import com.example.loginlivesession2.dto.PostRequestDto;
import com.example.loginlivesession2.dto.PostResponseDto;
import com.example.loginlivesession2.security.user.UserDetailsImpl;
import com.example.loginlivesession2.service.LikesService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class LikesController {
    private final LikesService likesService;

    // 좋아요 기능
    @PostMapping("/auth/post/likes/{postId}")
    public LikesResponseDto like(@AuthenticationPrincipal UserDetailsImpl userDetails, @RequestBody LikesRequestDto requestDto) {
        likesService.like(userDetails.getUser(), requestDto.getBoardId());
        return likesService.like(userDetails.getUser(), requestDto.getBoardId());
    }
}
