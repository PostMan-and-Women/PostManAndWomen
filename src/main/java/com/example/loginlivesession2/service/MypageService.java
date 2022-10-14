package com.example.loginlivesession2.service;// MypageService

import com.example.loginlivesession2.dto.CommentResponseDto;
import com.example.loginlivesession2.dto.LikesResponseDto;
import com.example.loginlivesession2.dto.PostResponseDto;
import com.example.loginlivesession2.dto.ResponseDto;
import com.example.loginlivesession2.entity.Likes;
import com.example.loginlivesession2.entity.Account;
import com.example.loginlivesession2.entity.Comment;
import com.example.loginlivesession2.entity.Post;
//import com.example.loginlivesession2.jwt.dto.MypageResponseDto;
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

//    @Transactional(readOnly=true)
//    public ResponseDto<?> getMypage(Account account){
//        List<Post> postList = postRepository.findAllByAccount(account);
//        List<Comment> commentList = commentRepository.findAllByAccount(account);
//        List<Likes> likesList = likesRepository.findAllByAccountId(account.getId());
//        return ResponseDto.success(
//                MypageResponseDto.builder()
//                        .id(account.getId())
//                        .username(account.getName())
//                        .email(account.getEmail())
//                        .posts(postList.stream().map(PostResponseDto::new).collect(Collectors.toList()))
//                        .comments(commentList.stream().map(CommentResponseDto::new).collect(Collectors.toList()))
//                        .likes(likesList.stream().map(LikesResponseDto::new).collect(Collectors.toList()))
//                        .build()
//        );
//
//    }
}