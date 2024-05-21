package com.team1.mohaji.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.team1.mohaji.entity.Board;
import jakarta.persistence.Column;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
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
@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime createdAt;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime updatedAt;
}
