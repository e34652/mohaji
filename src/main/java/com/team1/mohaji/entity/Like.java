package com.team1.mohaji.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.mapping.ToOne;

@Entity
@Data
public class Like {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "like_id")
    private int likeId;

    private Integer postId;
    private Integer commentId;
    private Integer memberId;
//    @ManyToOne
//    @JoinColumn(name = "post_id")
//    private Post post;
//    @ManyToOne
//    @JoinColumn(name = "comment_id")
//    private Comment comment;
//    @ManyToOne
//    @JoinColumn(name = "member_id")
//    private Member member;

}
