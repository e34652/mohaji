package com.team1.mohaji.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "reg_course")
public class RegCourse {

    @OneToMany(mappedBy = "reg_course")
    private List<RegSession> regSessions;

    @OneToOne(mappedBy = "reg_course")
    private RegDetail regDetail;

    @Id
    @ManyToOne(optional = true)
    @JoinColumn(name = "student_id", referencedColumnName = "student_id")
    private Student student;

    @Id
    @ManyToOne(optional = true)
    @JoinColumn(name = "sub_id" , referencedColumnName = "sub_id")
    private Subject subject;

    @Column(name = "cc_id", length = 30) // 공통기준 테이블 /select
    private String ccId;

    @NotBlank
    @Enumerated(EnumType.STRING)
    @Column(name = "rc_stat", length = 15 ,nullable = false)
    private RcStat rcStat;

    @NotBlank
    @Column(name = "rc_progress" , precision = 4, scale = 1, columnDefinition = "0")
    private BigDecimal rcProgress;

    @Column(name = "rc_asgn_score" )
    private Integer rcAsgnScore;

    @Column(name = "rc_att_score")
    private Integer rcAttScore;

    @Column(name = "rc_grade" , nullable = false ,columnDefinition = "none" )
    private String rcGrade;

    //
    public enum RcStat {
        Attending, //수강중
        Completed, //이수
        Cancelled //취소
    }
}
