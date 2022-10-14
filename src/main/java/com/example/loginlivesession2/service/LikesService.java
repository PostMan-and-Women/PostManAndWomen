package com.example.loginlivesession2.service;

import com.example.loginlivesession2.dto.LikesResponseDto;
import com.example.loginlivesession2.dto.ResponseDto;
import com.example.loginlivesession2.entity.Account;
import com.example.loginlivesession2.entity.Likes;
import com.example.loginlivesession2.repository.LikesRepository;
import com.example.loginlivesession2.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class LikesService {
    private final LikesRepository likesRepository;

    public LikesResponseDto like(Account account, Long likeId) {
        Likes likes = likesRepository.findById(likeId).orElseThrow(
                () -> new IllegalArgumentException("좋아요 정보가 존재하지 않습니다.")
        );

        // 로그인한 유저의 이메일과 likes의 유저 이메일 비교
        if(account.getEmail().equals(likes.getAccount().getEmail())) {}

        return new LikesResponseDto(likes);
    }

    public ResponseDto createLike(Account account, Long likeId) {
        Likes likes = likesRepository.findById(likeId).orElseThrow(
                () -> new IllegalArgumentException("좋아요 정보가 존재하지 않습니다.")
        );

        // 로그인한 유저의 이메일과 likes의 유저 이메일 비교
        if(account.getEmail().equals(likes.getAccount().getEmail())) {}

//        return new ResponseDto();
        return null;
    }
}
