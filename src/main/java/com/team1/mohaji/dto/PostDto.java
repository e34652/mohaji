package com.team1.mohaji.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime createdAt;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime updatedAt;


    public String getFormattedCreatedAt() {
        return createdAt.toLocalDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }
    public String getFormattedUpdatedAt() {
        return updatedAt.toLocalDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }


}

