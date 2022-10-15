package com.example.postmanandwomen.dto;

import com.example.postmanandwomen.entity.Likes;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class LikesResponseDto {
    private Long postId;

    private String postTitle;

    public LikesResponseDto(Likes likes) {
        this.postId = likes.getPost().getId();
        this.postTitle = likes.getPost().getTitle();
    }
}
