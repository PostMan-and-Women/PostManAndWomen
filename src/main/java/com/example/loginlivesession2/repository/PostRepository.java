package com.example.loginlivesession2.repository;

import com.example.loginlivesession2.dto.PostListResponseDto;
import com.example.loginlivesession2.entity.Account;
import com.example.loginlivesession2.entity.Comment;
import com.example.loginlivesession2.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<PostListResponseDto> findAllByOrderByModifiedAtDesc();
    List<Post> findAllByAccount(Account account);
}
