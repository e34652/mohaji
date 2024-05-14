package com.team1.mohaji.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

@Entity
@Table(name = "criteria_common")
public class CriteriaCommon {

    @OneToMany(mappedBy = "criteria_common")
    private List<CriteriaDetail> criteriaDetails;

    @Id
    @Column(name = "ct_id", length = 30 )
    private String ctId;

    @NotBlank
    @Column(name = "ct_title", nullable = false, length = 60)
    private String ctTitle;

    // Getters and setters
}
