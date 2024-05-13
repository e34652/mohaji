package com.team1.mohaji.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "reg_course")
public class RegCourse {
    @Id
    @ManyToOne
    @JoinColumn(name = "stu_id", referencedColumnName = "student_id")
    private Student student;

    @Id
    @ManyToOne
    @JoinColumn(name = "sub_id")
    private Subject subject;

    @Column(name = "cc_id")
    private String ccId;

    @Column(name = "rc_stat")
    private String rcStat;

    @Column(name = "rc_progress", nullable = false)
    private double rcProgress;

    @Column(name = "rc_asgn_score")
    private Integer rcAsgnScore;

    @Column(name = "rc_att_score")
    private Integer rcAttScore;

    @Column(name = "rc_grade")
    private String rcGrade;

    // Getters and setters
}
