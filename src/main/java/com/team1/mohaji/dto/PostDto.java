package com.team1.mohaji.dto;

import com.team1.mohaji.entity.Attached;
import com.team1.mohaji.entity.Board.Board;
import jakarta.persistence.Column;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@ToString
public class PostDto {
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
    private int memberId;
    //    @ManyToOne
//    @JoinColumn(name = "member_id")
//    @Column(name = "post_author_id")
//    private Member member;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
