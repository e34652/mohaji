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

    private Integer memberId;
//    @ManyToOne
//    @JoinColumn(name = "member_id")
//    private Member member;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Attached> attachments;

    @Override
    public String toString() {
        return "Post{" +
                "postId=" + postId +
                ", lectureId=" + lectureId +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", views=" + views +
                ", attachedId=" + attachedId +
                ", likeId=" + likeId +
                ", memberId=" + memberId +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
