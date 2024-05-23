package com.team1.mohaji.dto;

import com.team1.mohaji.entity.Post;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@AllArgsConstructor
@RequiredArgsConstructor
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

    public PostDto(Post post) {
        this.postId = post.getPostId(); // Assuming postId is getter method name
        this.title = post.getTitle();
        this.content = post.getContent();
        this.memberId = post.getMemberId();
    }

}

