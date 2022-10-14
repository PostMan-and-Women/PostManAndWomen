// CommentRequestDto.java
package com.example.loginlivesession2.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.Lob;

@Getter
@AllArgsConstructor
public class CommentRequestDto {
    @Lob
    private String content;
}