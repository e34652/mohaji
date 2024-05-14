package com.team1.mohaji.entity;

import jakarta.persistence.*;

//ip 등록
@Entity
public class MemberIp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mip_id")
    private int mipId;

    @ManyToOne
    @JoinColumn(name = "member_id", referencedColumnName = "member_id")
    private Member member;

    @Column(name="mip_ip", unique = true, nullable = false)
    private String mipIp;

    @Column(name="mip_name", nullable = false)
    private String mipName;



//    // 생성자
//    public MemberIp() {
//    }
//
//    // 게터와 세터
//    public int getMipId() {
//        return mipId;
//    }
//
//    public void setMipId(int mipId) {
//        this.mipId = mipId;
//    }
//
//    public int getMemberId() {
//        return memberId;
//    }
//
//    public void setMemberId(int memberId) {
//        this.memberId = memberId;
//    }
//
//    public String getMipIp() {
//        return mipIp;
//    }
//
//    public void setMipIp(String mipIp) {
//        this.mipIp = mipIp;
//    }
}