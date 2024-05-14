package com.team1.mohaji.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

@Entity
@Table(name = "session")
public class Session {

    @OneToMany(mappedBy = "session" )
    private List<RegSession> regSessions;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "session_ID")
    private int sessionId;

    @ManyToOne
    @JoinColumn(name = "sub_id", referencedColumnName = "sub_id")
    private Subject subject;

    @OneToOne
    @JoinColumn(name = "video_id")
    private Video video;

    @NotBlank
    @Column(name = "session_title", nullable = false, length = 90)
    private String sessionTitle;

    @NotBlank
    @Column(name = "session_snum", nullable = false)
    private int sessionSnum;

    // Getters and setters
}

