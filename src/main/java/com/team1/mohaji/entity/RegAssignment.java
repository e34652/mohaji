//package com.team1.mohaji.entity;
//
//import jakarta.persistence.*;
//
//import java.time.LocalDateTime;
//
//@Entity
//@Table(name = "reg_asgn")
//public class RegAssignment {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "ra_id")
//    private int raId;
//
//    @ManyToOne
//    @JoinColumn(name = "sub_id", nullable = false)
//    private Assignment assignment;
//
//    @ManyToOne
//    @JoinColumn(name = "stu_id", nullable = false)
//    private Student student;
//
//    @Column(name = "att_id")
//    private Integer attId;
//
//    @Column(name = "ra_content")
//    private String raContent;
//
//    @Column(name = "ra_sdate", nullable = false)
//    private LocalDateTime raSdate;
//
//    @Column(name = "ra_score")
//    private Integer raScore;
//
//    // Constructors, getters, and setters
//}
