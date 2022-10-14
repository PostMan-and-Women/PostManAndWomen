package com.example.loginlivesession2.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@NoArgsConstructor
public class AccountRequestDto {

    private static final String PASSWORD_REGEX = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[~!@#$%^&*()+|=])[A-Za-z\\d~!@#$%^&*()+|=]{8,16}";

    @NotBlank
    private String username;

    // 에러처리 1
    // 회원가입 시 이메일 형식이 유효하지 않은 경우,
    @NotBlank
    @Column(unique = true)
//    @Pattern(message = )
    @Email
    private String email;

    // 에러처리 2
    // 비밀번호가 영어대소문자, 숫자, 특수문자를 모두 포함하지 않은 경우 + 8 ~ 16자리    @NotBlank
    @Pattern(regexp = PASSWORD_REGEX)
    private String password;

    public AccountRequestDto(String email, String password, String username) {
        this.email = email;
        this.password = password;
        this.username = username;
    }

    public void setEncodePwd(String encodePwd) {
        this.password = encodePwd;
    }

}