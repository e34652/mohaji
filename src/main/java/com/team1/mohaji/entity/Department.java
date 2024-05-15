package com.team1.mohaji.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "department")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dept_id")
    private int deptId;

    @NotBlank
    @Column(name = "dept_name", nullable = false, length = 60)
    private String deptName;

    @Column(name = "dept_desc", length = 300)
    private String deptDesc;

    @Column(name = "cc_id", nullable = false, length = 30)
    private String ccId;

    // Getters and setters
}
