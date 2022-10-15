// Account.class
package com.example.loginlivesession2.entity;

import com.example.loginlivesession2.dto.AccountRequestDto;
import com.example.loginlivesession2.dto.TimeStamped;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Account extends TimeStamped {

    @Id @GeneratedValue
    @Column(name = "account_id")
    private Long id;

    @NotBlank
    @Column(unique = true)
    private String email;

    @NotBlank
    private String username;

    @NotBlank
    private String password;

    public Account(AccountRequestDto accountRequestDto) {
        this.email = accountRequestDto.getEmail();
        this.password = accountRequestDto.getPassword();
        this.username = accountRequestDto.getUsername();
    }
}