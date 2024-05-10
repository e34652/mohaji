package com.team1.mohaji.controller;

import com.team1.mohaji.service.Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class AuthenticatedController {
    @Autowired
    Service serviceInterface;


    @GetMapping("/authenticated")
        public String getAuthenticated(){

        return "/view/main";
        }
}
