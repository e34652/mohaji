package com.team1.mohaji.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
public class Post extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private int postId;
    @ManyToOne
    @JoinColumn(name = "board_id")
    private Board board;
    private Integer lectureId;
    private String title;
    private String content;
    private Integer views;
    @Column(nullable = true)
    private Integer attachedId;
    private Integer likeId;
//    @ManyToOne
//    @JoinColumn(name = "like_id")
//    private Like like;
    @Column(name = "member_id", nullable = false)
    private Integer memberId;
//    @ManyToOne
//    @JoinColumn(name = "member_id", nullable = false)
//    private Member member;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Attached> attachments;



}
