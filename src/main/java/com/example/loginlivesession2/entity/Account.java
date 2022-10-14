// Account.class
package com.example.loginlivesession2.entity;

import com.example.loginlivesession2.dto.AccountRequestDto;
import com.example.loginlivesession2.dto.TimeStamped;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Getter
@Entity
@NoArgsConstructor
public class Account extends TimeStamped {

    @Id @GeneratedValue
    @Column(name = "account_id")
    private Long id;

    @NotBlank
    @Column(unique = true)
    private String email;

    @NotBlank
    private String name;

    @NotBlank
    private String password;

    public Account(AccountRequestDto accountRequestDto) {
        this.email = accountRequestDto.getEmail();
        this.password = accountRequestDto.getPassword();
        this.name = accountRequestDto.getUsername();
    }
}