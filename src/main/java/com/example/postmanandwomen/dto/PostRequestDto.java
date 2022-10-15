package com.example.postmanandwomen.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class PostRequestDto {
    private String title;

    private String content;
}
