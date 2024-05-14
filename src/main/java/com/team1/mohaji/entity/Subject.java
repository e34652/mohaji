package com.team1.mohaji.entity;

import jakarta.persistence.*;
import org.apache.ibatis.annotations.One;

import java.util.List;

@Entity
@Table(name = "subject")
public class Subject {

    @OneToMany(mappedBy = "subject")
    private List<RegCourse> RegCourse;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sub_id")
    private int subId;

    @ManyToOne
    @JoinColumn(name = "dept_id", nullable = false)
    private Department department;

    // Assuming Pro is another entity, not provided in SQL
    @ManyToOne
    @JoinColumn(name = "prof_id", nullable = false)
    private Professor professor;

    @Column(name = "sub_name", nullable = false)
    private String subName;

    @Column(name = "sub_type", nullable = false)
    private String subType;

    @Column(name = "sub_desc")
    private String subDesc;

    @Column(name = "sub_scount", nullable = false)
    private int subScount;

    @Column(name = "sub_credit", nullable = false)
    private int subCredit;

    // Getters and setters
}
