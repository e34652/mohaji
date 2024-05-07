package com.team1.mohaji.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@Slf4j
public class AuthenticatedController {

    @GetMapping("/authenticated")
        public String getAuthenticated(){
            return "/view/test";
        }
}
