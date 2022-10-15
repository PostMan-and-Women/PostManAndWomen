// Comment.class
package com.example.postmanandwomen.entity;

import com.example.postmanandwomen.dto.TimeStamped;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class Comment extends TimeStamped {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")

    private Long id;

    // Post가 있다면 필요할까??
//    @Column(name = "cwriter")
    private String username;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "fk_board_id")
//    private Post post;

    @Lob
    private String comment;

    public Comment(Long postId, String comment) {
        this.comment = comment;
    }


}