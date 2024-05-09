package com.team1.mohaji.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "reg_result")
public class RegResult {
    @Id
    @ManyToOne
    @JoinColumn(name = "stu_id2", nullable = false)
    private Student student;

    @Id
    @ManyToOne
    @JoinColumn(name = "sub_id", nullable = false)
    private Subject subject;

    @ManyToOne
    @JoinColumn(name = "cc_id", nullable = false)
    private CriteriaCommon criteriaCommon;

    @Column(name = "rr_asgn_score")
    private Integer rrAsgnScore;

    @Column(name = "rr_att_score")
    private Integer rrAttScore;

    @Column(name = "rr_grade")
    private String rrGrade;

    // Constructors, getters, and setters
}
