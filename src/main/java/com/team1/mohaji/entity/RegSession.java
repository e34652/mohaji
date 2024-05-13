package com.team1.mohaji.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "reg_session")
public class RegSession {
    @Id
    @ManyToOne
    @JoinColumn(name = "stu_id", referencedColumnName = "student_id")
    private Student student;

    @Id
    @ManyToOne
    @JoinColumn(name = "sub_id")
    private Subject subject;

    @Id
    @Column(name = "session_ID")
    private int sessionId;

    @Column(name = "rs_progress", nullable = false)
    private double rsProgress;

    @Column(name = "rs_max", nullable = false)
    private int rsMax;

    @Column(name = "rs_final", nullable = false)
    private int rsFinal;

    // Getters and setters
}
