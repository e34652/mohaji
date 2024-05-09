//package com.team1.mohaji.entity;
//
//import jakarta.persistence.*;
//import lombok.Data;
//import lombok.EqualsAndHashCode;
//
//import java.time.LocalDateTime;
//
//@Data
//@Entity
//@Table(name = "noti_recipients")
//@EqualsAndHashCode(callSuper = true)
//public class NotificationRecipient extends BaseEntity {
//
//    @ManyToOne
//    @JoinColumn(name = "noti_id", nullable = false)
//    private Notification notification;
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int serialId;
//
//    @Column(nullable = false)
//    private String recipientId;
//
//    private LocalDateTime readAt;
//
//    @Column(nullable = false)
//    private boolean read;
//
//    @Column(nullable = false)
//    private boolean removed;
//}