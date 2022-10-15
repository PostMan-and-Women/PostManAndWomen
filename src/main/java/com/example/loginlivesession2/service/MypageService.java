package com.example.loginlivesession2.service;// MypageService

import com.example.loginlivesession2.dto.*;
import com.example.loginlivesession2.entity.Likes;
import com.example.loginlivesession2.entity.Account;
import com.example.loginlivesession2.entity.Comment;
import com.example.loginlivesession2.entity.Post;
import com.example.loginlivesession2.jwt.dto.TokenDto;
import com.example.loginlivesession2.jwt.util.JwtUtil;
import com.example.loginlivesession2.repository.AccountRepository;
import com.example.loginlivesession2.repository.CommentRepository;
import com.example.loginlivesession2.repository.LikesRepository;
import com.example.loginlivesession2.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class MypageService {

    private final PostRepository postRepository;
    private final AccountRepository accountRepository;
    private final CommentRepository commentRepository;
    private final LikesRepository likesRepository;
    private JwtUtil jwtUtil;

    // 마이페이지 조회
    @Transactional(readOnly=true)
    public ResponseDto<?> getMypage(Account account){
        List<Post> postList = postRepository.findAllByAccount(account);
        List<Comment> commentList = commentRepository.findAllByAccount(account);
        List<Likes> likesList = likesRepository.findAllByAccount(account);
        return ResponseDto.success(
                MypageResponseDto.builder()
                        .id(account.getId())
                        .username(account.getUsername())
                        .email(account.getEmail())
                        .posts(postList.stream().map(PostResponseDto::new).collect(Collectors.toList()))
                        .comments(commentList.stream().map(CommentResponseDto::new).collect(Collectors.toList()))
                        .likes(likesList.stream().map(LikesResponseDto::new).collect(Collectors.toList()))
                        .build()
        );
    }
    //
    @Transactional
    public ResponseDto<?> updateMypage(AccountRequestDto accountRequestDto,Account account){
        return ResponseDto.success("수정 완료");

    }


    // 회원 탈퇴

    @Transactional
    public ResponseDto<?> deleteMypage(Account account) {
        // post 삭제와 같은 함수 사용으로 대체
        List<Post> postList = postRepository.findAllByAccount(account);
        for (Post post : postList) {
            commentRepository.deleteAll(commentRepository.findAllByPost(post));
            likesRepository.deleteAll(likesRepository.findAllByPost(post));
        }
        //
        likesRepository.deleteAll(likesRepository.findAllByAccount(account));
        commentRepository.deleteAll(commentRepository.findAllByAccount(account));
        postRepository.deleteAll(postRepository.findAllByAccount(account));
        return ResponseDto.success("post delete success");
    }
}