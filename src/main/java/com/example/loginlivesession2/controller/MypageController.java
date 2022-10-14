package com.example.loginlivesession2.controller;// MypageController

import com.example.loginlivesession2.dto.ResponseDto;
import com.example.loginlivesession2.jwt.util.JwtUtil;
import com.example.loginlivesession2.security.user.UserDetailsImpl;
import com.example.loginlivesession2.service.AccountService;
import com.example.loginlivesession2.service.MypageService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MypageController {
    private final JwtUtil jwtUtil;
    private final AccountService accountService;

    // 내 게시글, 댓글, 좋아요 보기
//    @GetMapping("/mypage/{id}")
//    public ResponseDto<?> get(@PathVariable Long id, @AuthenticationPrincipal UserDetailsImpl userDetails){
//        return MypageService.getMypage(id, userDetails.getAccount());
//    }

}