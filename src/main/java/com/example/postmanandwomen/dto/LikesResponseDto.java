package com.example.postmanandwomen.dto;

import com.example.postmanandwomen.entity.Likes;

public class LikesResponseDto {
    private String email;

    public LikesResponseDto (Likes likes) {
        this.email = likes.getAccount().getEmail();
    }
}
