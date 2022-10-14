package com.example.loginlivesession2.dto;

import com.example.loginlivesession2.entity.Account;
import com.example.loginlivesession2.entity.Post;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
public class PostResponseDto {
    private String title;

    private String content;

    private LocalDateTime createdAt;

    private LocalDateTime modifiedAt;

    private String name;

    public PostResponseDto(Account account, Post post) {
        this.name = account.getName();
        this.title = post.getTitle();
        this.content = post.getContent();
        this.createdAt = post.getCreatedAt();
        this.modifiedAt = post.getCreatedAt();
    }
}
