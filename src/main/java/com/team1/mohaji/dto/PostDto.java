package com.team1.mohaji.dto;

import com.team1.mohaji.entity.Board;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class PostDto {
    private Integer boardId;
    private Integer postId;
    private Integer lectureId;
    private String title;
    private String content;
    private Integer views;
    private Integer attachedId;
    private Integer likeId;
    private Integer memberId;
    private String memberName;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
