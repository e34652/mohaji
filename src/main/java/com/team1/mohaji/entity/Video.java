package com.team1.mohaji.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "video")
public class Video {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "video_id")
    private int videoId;

    @Column(name = "video_ycode", nullable = false)
    private String videoYcode;

    @Column(name = "video_title", nullable = false)
    private String videoTitle;

    @Column(name = "video_content")
    private String videoContent;

    @Column(name = "video_length", nullable = false)
    private int videoLength;

    // Constructors, getters, and setters
}
