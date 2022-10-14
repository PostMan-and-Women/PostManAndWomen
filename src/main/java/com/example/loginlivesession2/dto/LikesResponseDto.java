package com.example.loginlivesession2.dto;

import com.example.loginlivesession2.entity.Account;
import com.example.loginlivesession2.entity.Likes;

public class LikesResponseDto {
    private String email;

    public LikesResponseDto (Likes likes) {
        this.email = likes.getAccount().getEmail();
    }
}
