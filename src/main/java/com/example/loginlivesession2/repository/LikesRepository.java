package com.example.loginlivesession2.repository;

import com.example.loginlivesession2.entity.Account;
import com.example.loginlivesession2.entity.Comment;
import com.example.loginlivesession2.entity.Likes;
import com.example.loginlivesession2.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LikesRepository extends JpaRepository<Likes, Long> {
    List<Likes> findAllByAccountId(Long id);
}
