package com.example.postmanandwomen.dto;

import jdk.jshell.Snippet;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MypageResponseDto {
    private Long id;
    private String username;
    private String email;
    private List<PostResponseDto> posts;
    private List<CommentResponseDto> comments;
    private List<LikesResponseDto> likes;

    @Builder
    @AllArgsConstructor
    @Getter
    @NoArgsConstructor
    public static class MyInfo{
        private Long id;
        private String username;
        private String email;
    }
}
