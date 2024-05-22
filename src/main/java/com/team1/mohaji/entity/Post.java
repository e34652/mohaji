package com.team1.mohaji.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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

    @Column(name = "member_id", nullable = false)
    private Integer memberId;

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

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Attached> attachments;


    @Override
    public String toString() {
        return "Post{" +
                "postId=" + postId +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", memberId=" + memberId +
                ", createdAt=" + createdAt +
                ", boardId=" + board.getBoardId() +
                ", attachments=" + attachments +
                '}';
    }
}
