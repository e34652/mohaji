package com.team1.mohaji.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "reg_detail")
public class RegDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rd_id")
    private int rdId;

    @ManyToOne
    @JoinColumn(name = "stu_id", referencedColumnName = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "sub_id")
    private Subject subject;

    @Column(name = "rd_adate", nullable = false)
    private Timestamp rdAdate;

    @Column(name = "rd_cdate")
    private Timestamp rdCdate;

    @Column(name = "rd_creason")
    private String rdCreason;

    // Getters and setters
}
