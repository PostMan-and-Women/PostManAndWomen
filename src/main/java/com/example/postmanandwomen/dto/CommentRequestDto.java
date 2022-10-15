package com.example.postmanandwomen.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.Lob;

@Getter
@AllArgsConstructor
public class CommentRequestDto {
    @Lob
    private String content;
}