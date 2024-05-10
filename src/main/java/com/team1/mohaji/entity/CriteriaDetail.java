package com.team1.mohaji.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "criteria_detail")
public class CriteriaDetail {
    @Id
    @Column(name = "cv_id", nullable = false)
    private String cvId;

    @ManyToOne
    @JoinColumn(name = "ct_id", nullable = false)
    private CriteriaCommon criteriaCommon;

    @Column(name = "cv_title", nullable = false)
    private String cvTitle;

    @Column(name = "cv_value1")
    private Integer cvValue1;

    @Column(name = "cv_value2")
    private Integer cvValue2;

    @Column(name = "cv_value3")
    private Integer cvValue3;

    @Column(name = "cv_value4")
    private Integer cvValue4;

    @Column(name = "cv_value5")
    private Integer cvValue5;

    @Column(name = "cv_desc")
    private String cvDesc;

    // Constructors, getters, and setters
}