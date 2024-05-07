package com.team1.mohaji.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UnauthenticatedController {

        @GetMapping("/unauthenticated")
        public String getAuthenticated(){
            return "Unauthenticated 페이지";
        }
}
