package com.team1.mohaji.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name="professors")
public class Professor extends BaseEntity {

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "member_id", referencedColumnName = "member_id", nullable = false, unique=true)
    private Member member;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "prof_id")
    private int profId;

    @Column(name = "dept_id")
    private int deptId = 1;

    @Column(name = "prof_code", unique = true)
    private String profCode;

    @Column(name = "appointed_date")
    private LocalDateTime appointedDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "title")
    private Title title;


    public enum Title {
        FULL,
        ASSOCIATE,
        ASSISTANT,
        INSTRUCTOR
    }
}
