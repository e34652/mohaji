package com.team1.mohaji.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "reg_course")
public class RegCourse {
    @Id
    @ManyToOne
    @JoinColumn(name = "stu_id", nullable = false)
    private Student student;

    @Id
    @ManyToOne
    @JoinColumn(name = "sub_id", nullable = false)
    private Subject subject;

    @Column(name = "rc_stat")
    private String rcStat;

    @Column(name = "rc_progress", nullable = false)
    private double rcProgress;

    // Constructors, getters, and setters
}
