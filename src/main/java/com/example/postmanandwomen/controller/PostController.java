package com.example.postmanandwomen.controller;

import com.example.postmanandwomen.dto.PostListResponseDto;
import com.example.postmanandwomen.dto.PostRequestDto;
import com.example.postmanandwomen.dto.PostResponseDto;
import com.example.postmanandwomen.security.user.UserDetailsImpl;
import com.example.postmanandwomen.service.PostService;
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
        return postService.createPost(userDetails.getAccount(), requestDto);
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
        return postService.updatePost(userDetails.getAccount(), postId, requestDto);
    }

    // 글 삭제
    @DeleteMapping("/auth/post/{postId}")
    public Long deletePost(@AuthenticationPrincipal UserDetailsImpl userDetails, @PathVariable Long postId) {
        return postService.deletePost(userDetails.getAccount(), postId);
    }
}
