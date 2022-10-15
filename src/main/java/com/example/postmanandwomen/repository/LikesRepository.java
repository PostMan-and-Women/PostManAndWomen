package com.example.postmanandwomen.repository;

import com.example.postmanandwomen.entity.Account;
import com.example.postmanandwomen.entity.Likes;
import com.example.postmanandwomen.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LikesRepository extends JpaRepository<Likes, Long> {
    List<Likes> findAllByAccount(Account account);
    List<Likes> findAllByPost(Post post);
}
