package com.team1.mohaji.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "reg_asgn")
public class RegAssignment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ra_id")
    private int raId;

    @ManyToOne
    @JoinColumn(name = "sub_id")
    private Assignment assignment;

    @ManyToOne
    @JoinColumn(name = "stu_id", referencedColumnName = "student_id")
    private Student student;

    @Column(name = "att_id")
    private Integer attId;

    @Column(name = "ra_content", length = 4000)
    private String raContent;

    @Column(name = "ra_sdate", nullable = false)
    private Timestamp raSdate;

    @Column(name = "ra_score")
    private Integer raScore;

    @Column(name = "ra_feedback", length = 4000)
    private String raFeedback;

    // Getters and setters
}
