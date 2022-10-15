package com.example.postmanandwomen.service;

import com.example.postmanandwomen.dto.LikesRequestDto;
import com.example.postmanandwomen.dto.ResponseDto;
import com.example.postmanandwomen.entity.Account;
import com.example.postmanandwomen.repository.LikesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class LikesService {
    private final LikesRepository likesRepository;

    public ResponseDto like(Account account, LikesRequestDto likesRequestDto, Long postId) {
//        Likes likes = likesRepository.findAllByPost(postId).orElseThrow(
//                () -> new IllegalArgumentException("좋아요 정보가 존재하지 않습니다.")
//        );

        // 로그인한 유저의 이메일과 likes의 유저 이메일 비교
//        if(account.getEmail().equals(likes.getAccount().getEmail())) {}

        return ResponseDto.success("");
    }

}
