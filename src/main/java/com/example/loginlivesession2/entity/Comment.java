// Comment.class
package com.example.loginlivesession2.entity;

import com.example.loginlivesession2.dto.TimeStamped;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class Comment extends TimeStamped {

    @Id @GeneratedValue
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