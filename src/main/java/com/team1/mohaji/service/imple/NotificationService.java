package com.team1.mohaji.service.imple;

import com.team1.mohaji.dto.NotificationDto;
import com.team1.mohaji.entity.Notification;
import com.team1.mohaji.repository.NotificationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class NotificationService {

    private NotificationRepository notificationRepository;

    public NotificationService(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    public boolean issueNotification(NotificationDto notificationDto){
        boolean isIssued = false;
        String userId = null;

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        userId = authentication.getName();

        Notification notification = new Notification();
        notification.setMessage(notificationDto.getMessage());
        notification.setTargetPath(notificationDto.getTargetPath());

        Notification savedNotification = notificationRepository.save(notification);
        if(null != savedNotification && savedNotification.getNotiId()>0){
            isIssued=true;
        }
        return isIssued;

    }
}
