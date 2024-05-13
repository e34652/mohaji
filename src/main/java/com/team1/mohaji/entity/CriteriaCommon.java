package com.team1.mohaji.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "criteria_common")
public class CriteriaCommon {
    @Id
    @Column(name = "ct_id")
    private String ctId;

    @Column(name = "ct_title", nullable = false)
    private String ctTitle;

    // Getters and setters
}
