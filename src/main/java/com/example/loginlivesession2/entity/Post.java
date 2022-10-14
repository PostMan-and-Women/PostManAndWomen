package com.example.loginlivesession2.entity;

import com.example.loginlivesession2.dto.PostRequestDto;
import com.example.loginlivesession2.dto.TimeStamped;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class Post extends TimeStamped {
    // 글 고유 아이디
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "postId")
    private Long id;

    // 글 제목
    @Column(nullable = false)
    private String title;

    // 글 내용
    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private String email;

    @ManyToOne
    @JoinColumn(name = "accountId")
    private Account account;

    @JsonIgnore
    @OneToMany(mappedBy = "post")
    List<Likes> likes = new ArrayList<>();

    public Post(Account account, PostRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.content = requestDto.getContent();
        this.account = account;
        this.email = account.getEmail();
    }
    // 업데이트 메소드
    public void update(PostRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.content = requestDto.getContent();
    }

}
