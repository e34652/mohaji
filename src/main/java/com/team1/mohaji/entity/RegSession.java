//package com.team1.mohaji.entity;
//
//import jakarta.persistence.*;
//
//@Entity
//@Table(name = "reg_session")
//public class RegSession {
//    @Id
//    @ManyToOne
//    @JoinColumn(name = "stu_id", nullable = false)
//    private Student student;
//
//    @Id
//    @ManyToOne
//    @JoinColumn(name = "sub_id", nullable = false)
//    private Subject subject;
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "session_ID")
//    private int sessionId;
//
//    @Column(name = "rs_progress", nullable = false)
//    private double rsProgress;
//
//    @Column(name = "rs_max", nullable = false)
//    private int rsMax;
//
//    @Column(name = "rs_current", nullable = false)
//    private int rsCurrent;
//
//    @Column(name = "rs_end", nullable = false)
//    private int rsEnd;
//
//    // Constructors, getters, and setters
//}
