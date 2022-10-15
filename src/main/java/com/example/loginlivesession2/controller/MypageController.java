package com.example.loginlivesession2.controller;// MypageController

import com.example.loginlivesession2.dto.AccountRequestDto;
import com.example.loginlivesession2.dto.AccountUpdateDto;
import com.example.loginlivesession2.dto.ResponseDto;
import com.example.loginlivesession2.jwt.util.JwtUtil;
import com.example.loginlivesession2.security.user.UserDetailsImpl;
import com.example.loginlivesession2.service.AccountService;
import com.example.loginlivesession2.service.MypageService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth/mypage")
public class MypageController {
    private final JwtUtil jwtUtil;
    private final AccountService accountService;
    private final MypageService mypageService;

    // 내 게시글, 댓글, 좋아요 보기
    @GetMapping("")
    public ResponseDto<?> getMp(@AuthenticationPrincipal UserDetailsImpl userDetails){
        return mypageService.getMypage(userDetails.getAccount());
    }

    // 회원정보 수정
    @PatchMapping("")
    public ResponseDto<?> updateMp(@Valid @RequestBody AccountRequestDto accountRequestDto,
                                   @AuthenticationPrincipal UserDetailsImpl userDetails){
        return mypageService.updateMypage(accountRequestDto, userDetails.getAccount());
    }

    // 회원 탈퇴
    @DeleteMapping("")
    public ResponseDto<?> deleteMp(@AuthenticationPrincipal UserDetailsImpl userDetails){
        return mypageService.deleteMypage(userDetails.getAccount());
    }

}