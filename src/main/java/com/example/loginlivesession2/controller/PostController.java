package com.example.loginlivesession2.controller;

import com.example.loginlivesession2.dto.PostListResponseDto;
import com.example.loginlivesession2.dto.PostRequestDto;
import com.example.loginlivesession2.dto.PostResponseDto;
import com.example.loginlivesession2.security.user.UserDetailsImpl;
import com.example.loginlivesession2.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class PostController {
    private final PostService postService;

    // 글 등록
    @PostMapping("/post")
    public PostResponseDto createPost(@AuthenticationPrincipal UserDetailsImpl userDetails, @RequestBody PostRequestDto requestDto) {
        return postService.createPost(userDetails.getUser(), requestDto);
    }
    // 전체 목록 조회
    @GetMapping("/post")
    public List<PostListResponseDto> getAllPosts() {
        return postService.findAllPosts();
    }

    // 글 하나 조회
    @GetMapping("/post/{postId}")
    public PostResponseDto getOnePost(@PathVariable Long postId) {
        return postService.findOnePost(postId);
    }

    // 글 수정
    @PutMapping("/auth/post/{postId}")
    public Long updatePost(@AuthenticationPrincipal UserDetailsImpl userDetails, @PathVariable Long postId, @RequestBody PostRequestDto requestDto) {
        return postService.updatePost(userDetails.getUser(), postId, requestDto);
    }

    // 글 삭제
    @DeleteMapping("/auth/post/{postId}")
    public Long deletePost(@AuthenticationPrincipal UserDetailsImpl userDetails, @PathVariable Long postId) {
        return postService.deletePost(userDetails.getUser(), postId);
    }
}
