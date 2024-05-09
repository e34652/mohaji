package com.team1.mohaji.dto;

import lombok.Data;

@Data
public class NotificationDto {

    private long id;
    private String authorId;
    private String message;
    private String targetPath;

}
