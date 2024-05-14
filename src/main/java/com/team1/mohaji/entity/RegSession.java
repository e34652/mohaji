package com.team1.mohaji.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;

@Entity
@Table(name = "reg_session")
public class RegSession {

    @Id
    @ManyToOne
    @JoinColumn(name = "sub_id", referencedColumnName = "sub_id")
    @JoinColumn(name = "student_id", referencedColumnName = "student_id")
    private RegCourse regCourse;

    @ManyToOne
    @JoinColumn(name = "session_id", referencedColumnName = "session_id")
    private Session session;

    @NotBlank
    @Column(name = "rs_progress", nullable = false, precision = 4, scale = 1 , columnDefinition = "int default 0")
    private BigDecimal rsProgress;

    @NotBlank
    @Column(name = "rs_max", nullable = false, columnDefinition = "int default 0")
    private int rsMax;

    @NotBlank
    @Column(name = "rs_final", nullable = false, columnDefinition = "int default 0")
    private int rsFinal;

    // Getters and setters
}
