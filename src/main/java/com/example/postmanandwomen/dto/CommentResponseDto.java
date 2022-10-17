package com.example.postmanandwomen.dto;

import com.example.postmanandwomen.entity.Comment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CommentResponseDto {
    private Long id;
    private String username;
    private String comment;
    private String createdAt;
    private String modifiedAt;

    public CommentResponseDto(Comment comment) {
        this.id = comment.getId();
        this.username = comment.getAccount().getUsername();
        this.comment = comment.getComment();
        this.createdAt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(comment.getCreatedAt());
        this.modifiedAt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(comment.getModifiedAt());
    }
}