package com.team1.mohaji.controller;

import com.team1.mohaji.dto.NotificationDto;
import com.team1.mohaji.service.imple.NotificationService;
import groovy.util.logging.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
public class NotificationController {

    private NotificationService notificationService;

    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }


    @ResponseBody
    @PostMapping("/notification/issue")
    public String issueNotification(@RequestBody NotificationDto notificationDto){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        notificationDto.setAuthorId(username);

        if(notificationService.issueNotification(notificationDto)){
            return "알림 발신 성공";
        } else {
            return "알림 발신 실패";
        }
    }

    @GetMapping("/notification")
    public String retrieveNotification(){
        return "view/notification";
    }
}
