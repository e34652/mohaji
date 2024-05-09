package com.team1.mohaji.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "department")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dept_id")
    private int deptId;

    @Column(name = "dept_name", nullable = false)
    private String deptName;

    @Column(name = "dept_desc")
    private String deptDesc;

    @Column(name = "dept_credit", nullable = false)
    private int deptCredit;

    // Constructors, getters, and setters
}
