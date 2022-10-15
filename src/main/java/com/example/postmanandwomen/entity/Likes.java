package com.example.postmanandwomen.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Likes {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "likesId")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "postId")
    private Post post;

    @ManyToOne
    @JoinColumn(name = "accountId")
    private Account account;
}
