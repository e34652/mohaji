package com.team1.mohaji.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class UnauthenticatedController {

        @GetMapping("/unauthenticated")
        public String getAuthenticated(){
            return "Unauthenticated 페이지";
        }
}
