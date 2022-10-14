// AccountController.java
package com.example.loginlivesession2.controller;

import com.example.loginlivesession2.dto.AccountRequestDto;
import com.example.loginlivesession2.dto.LoginRequestDto;
import com.example.loginlivesession2.service.AccountService;
import com.example.loginlivesession2.global.dto.GlobalResDto;
import com.example.loginlivesession2.jwt.util.JwtUtil;
import com.example.loginlivesession2.security.user.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@RestController
@RequestMapping("/account")
@RequiredArgsConstructor
public class AccountController {

    private final JwtUtil jwtUtil;
    private final AccountService accountService;

//    @PostMapping("/account/signup")
//    public GlobalResDto signup(@RequestBody @Valid AccountRequestDto accountRequestDto) {
//        System.out.println("AccountController.signup");
//        return accountService.signup(accountRequestDto);
//    }
//
//    @PostMapping("/account/login")
//    public GlobalResDto login(@RequestBody @Valid LoginRequestDto loginRequestDto, HttpServletResponse response) {
//        return accountService.login(loginRequestDto, response);
//    }

    /**
     * 이 부분은 로그인 한 다음......?
     */
    @GetMapping("/issue/token")
    public GlobalResDto issuedToken(@AuthenticationPrincipal UserDetailsImpl userDetails, HttpServletResponse response){
        response.addHeader(JwtUtil.ACCESS_TOKEN, jwtUtil.createToken(userDetails.getAccount().getEmail(), "Access"));
        return new GlobalResDto("Success IssuedToken", HttpStatus.OK.value());
    }

}