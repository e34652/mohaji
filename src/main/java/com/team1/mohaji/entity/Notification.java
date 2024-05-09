package com.team1.mohaji.entity;

import com.team1.mohaji.entity.base.CreateEntity;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "notifications")
public class Notification extends CreateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int notiId;

    @Column(nullable = false)
    private String message;

    @Column(nullable = false)
    private String targetPath;

//    @OneToMany(mappedBy = "notification", cascade = CascadeType.ALL)
//    private List<NotificationRecipient> recipients;

}
