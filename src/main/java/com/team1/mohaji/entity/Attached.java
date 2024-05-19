package com.team1.mohaji.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Attached extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int attachedId;
    private int serialId;
    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;
    private String storagePath;
    private String originalName;
    private String savedName;
    private String attachedType;
    private Long attachedSize;
    private int downloads;
    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

}
