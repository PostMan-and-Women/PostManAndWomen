package com.example.postmanandwomen.service;

import com.example.postmanandwomen.dto.*;
import com.example.postmanandwomen.entity.Account;
import com.example.postmanandwomen.entity.Comment;
import com.example.postmanandwomen.entity.Post;
import com.example.postmanandwomen.repository.CommentRepository;
import com.example.postmanandwomen.repository.LikesRepository;
import com.example.postmanandwomen.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostService {
    private final PostRepository postRepository;
    private final LikesRepository likesRepository;
    private final CommentRepository commentRepository;

    // 글 생성 (user 매핑)
    public PostResponseDto createPost(Account account, PostRequestDto requestDto) {
        Post post = new Post(account, requestDto);
        postRepository.save(post);
        return new PostResponseDto(post);
    }

    // 글 목록 가져오기
    public List<PostListResponseDto> findAllPosts() {
        return postRepository.findAllByOrderByModifiedAtDesc();
    }

    // 글 하나 가져오기
    public ResponseDto findOnePost(Long id) {
        Post post = postRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("게시글이 없습니다")
        );
        Long likeNum = Long.valueOf(likesRepository.findAllByPost(post).size());
        List<Comment> commentList = commentRepository.findAllByPost(post);
        List<CommentResponseDto> responseDtoList = commentList.stream().map(CommentResponseDto::new).collect(Collectors.toList());

        PostListResponseDto response = new PostListResponseDto(post, likeNum, responseDtoList);
        return ResponseDto.success(response);
    }

    // 글 수정
    @Transactional
    public Long updatePost(Account account, Long id, PostRequestDto requestDto) {
        // 어떤 게시판인지 찾기
        Post post = postRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 게시글이 존재하지 않습니다.")
        );

        // 게시판의 username과 로그인 유저의 username 비교
        if (account.getUsername().equals(post.getAccount().getUsername())) {
            post.update(requestDto);
            return post.getId();
        } else {
            throw new IllegalArgumentException("작성자만 수정할 수 있습니다");
        }
    }

    // 삭제
    @Transactional
    public Long deletePost(Account account, Long id) {
        // 어떤 게시판인지 찾기
        Post post = postRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 게시글이 존재하지 않습니다.")
        );

        // 게시판의 email과 로그인 유저의 email 비교
        if (account.getEmail().equals(post.getAccount().getEmail())) {
            postRepository.deleteById(id);
            return id;
        } else {
            throw new IllegalArgumentException("작성자만 수정할 수 있습니다");
        }
    }
}
