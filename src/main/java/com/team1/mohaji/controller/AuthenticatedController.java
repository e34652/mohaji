package com.team1.mohaji.controller;

import com.team1.mohaji.service.ServiceInterface;
import com.team1.mohaji.service.imple.Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@Slf4j
public class AuthenticatedController {
    @Autowired
    ServiceInterface serviceInterface;

//"/authenticated"
    @GetMapping("/aa")
        public String getAuthenticated(){
log.info("{}", serviceInterface.findMemberByNum(1));
        return "/view/test";
        }
}
