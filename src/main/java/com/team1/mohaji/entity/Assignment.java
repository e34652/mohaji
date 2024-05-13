package com.team1.mohaji.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "asgn")
public class Assignment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "asgn_id")
    private int asgnId;

    @ManyToOne
    @JoinColumn(name = "sub_id")
    private Subject subject;

    @Column(name = "att_id", nullable = false)
    private int attId;

    @Column(name = "asgn_desc")
    private Integer asgnDesc;

    @Column(name = "asgn_rdate", nullable = false)
    private Date asgnRdate;

    @Column(name = "asgn_ddate", nullable = false)
    private Date asgnDdate;

    // Getters and setters
}
