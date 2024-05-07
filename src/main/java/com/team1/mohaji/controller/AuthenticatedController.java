package com.team1.mohaji.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticatedController {

    @GetMapping("/authenticated")
        public String getAuthenticated(){
            return "Authenticated 페이지";
        }
}
