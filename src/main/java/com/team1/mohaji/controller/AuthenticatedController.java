package com.team1.mohaji.controller;

import com.team1.mohaji.config.MemberDetail;
import com.team1.mohaji.service.Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@Slf4j
public class AuthenticatedController {
    @Autowired
    Service serviceInterface;


    @GetMapping("/authenticated")
        public String getAuthenticated(){
        log.info("{}", serviceInterface.findMemberByNum(1));
        return "/view/test";
        }

    @GetMapping("/")
    public String test(){
        return "/view/mypage";
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<?> userCheck(@PathVariable String loginId, @AuthenticationPrincipal MemberDetail memberDetail) {
        String username = memberDetail.getUsername();
        String role = String.valueOf(memberDetail.getMember().getRole());
        return ResponseEntity.ok().body(username + " : "+ role);
    }
}
