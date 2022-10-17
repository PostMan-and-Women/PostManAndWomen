package com.example.postmanandwomen.dto;

import com.example.postmanandwomen.entity.Account;
import com.example.postmanandwomen.entity.Post;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@NoArgsConstructor
@Getter
public class PostResponseDto {
    private String title;

    private String content;

    private String createdAt;

    private String modifiedAt;

    private String username;

    public PostResponseDto(Post post) {
        this.username = post.getAccount().getUsername();
        this.title = post.getTitle();
        this.content = post.getContent();
        this.createdAt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(post.getCreatedAt());
        this.modifiedAt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(post.getModifiedAt());
    }
}
