package com.example.loginlivesession2.dto;

import lombok.*;


@Getter
@NoArgsConstructor
@Setter
@AllArgsConstructor
public class AccountUpdateDto {
    private String email;
    private String username;
    private String password;
    private String passwordConfirm;
}
