// CommentRepository
package com.example.loginlivesession2.repository;

import com.example.loginlivesession2.entity.Account;
import com.example.loginlivesession2.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findAllByBoardId(Long postId);
    List<Comment> findAllByAccount(Account account);
}