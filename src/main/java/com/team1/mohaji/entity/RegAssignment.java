package com.team1.mohaji.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.sql.Timestamp;

//과제제출정보
@Entity
@Table(name = "reg_asgn")
public class RegAssignment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ra_id")
    private int raId;

    @ManyToOne(optional = true) //비식별
    @JoinColumn(name = "asgn_id",  referencedColumnName = "asgn_id")
    private Assignment assignment;

    @ManyToOne(optional = true) //비식별
    @JoinColumn(name = "student_id", referencedColumnName = "student_id")
    private Student student;

    @NotBlank
    @Column(name = "attached_id", nullable = false) // attached 테이블에서 select
    private Integer attachedId;

    @Column(name = "ra_content", length = 4000)
    private String raContent;

    @NotBlank
    @Column(name = "ra_sdate", nullable = false)
    private Timestamp raSdate;

    @NotBlank
    @Column(name = "ra_score", nullable = false, columnDefinition = "0")
    private Integer raScore;

    @Column(name = "ra_feedback", length = 4000)
    private String raFeedback;

    // Getters and setters
}
