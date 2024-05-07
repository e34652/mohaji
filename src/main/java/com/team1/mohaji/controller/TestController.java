package com.team1.mohaji.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Controller
public class TestController {

        @GetMapping("/")
        public String main(){
            return "/view/test";
        }
    }

