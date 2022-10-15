package com.example.postmanandwomen.service;

import com.example.postmanandwomen.dto.LikesRequestDto;
import com.example.postmanandwomen.dto.ResponseDto;
import com.example.postmanandwomen.entity.Account;
import com.example.postmanandwomen.entity.Likes;
import com.example.postmanandwomen.entity.Post;
import com.example.postmanandwomen.repository.LikesRepository;
import com.example.postmanandwomen.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class LikesService {
    private final LikesRepository likesRepository;
    private final PostRepository postRepository;

    @Transactional
    public ResponseDto like(Account account, Long postId) {
        Post post = postRepository.findById(postId).orElseThrow(
                () -> new IllegalArgumentException("게시글 정보가 존재하지 않습니다.")
        );

        Optional<Likes> likes = likesRepository.findAllByPostAndAccount(post, account);

        if(likes.isPresent()) {
            likesRepository.deleteById(likes.get().getId());
            return ResponseDto.success("좋아요가 취소되었습니다");
        } else{
            Likes userLike = new Likes(post,account);
            likesRepository.save(userLike);
            return ResponseDto.success("좋아요가 등록되었습니다");
        }
    }
}
