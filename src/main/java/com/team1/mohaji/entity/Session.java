package com.team1.mohaji.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "session")
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "session_ID")
    private int sessionId;

    @ManyToOne
    @JoinColumn(name = "sub_id", nullable = false)
    private Subject subject;

    @ManyToOne
    @JoinColumn(name = "video_id", nullable = false)
    private Video video;

    @Column(name = "session_title", nullable = false)
    private String sessionTitle;

    @Column(name = "session_snum", nullable = false)
    private int sessionSnum;

    // Constructors, getters, and setters
}
