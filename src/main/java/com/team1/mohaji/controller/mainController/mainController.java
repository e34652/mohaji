package com.team1.mohaji.controller.mainController;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class mainController {

    @GetMapping("/")
    public  String main1()
    {return "/view/myPage/mypPC";}

    @GetMapping("/main")
    public  String main2(){
    return "/view/main";
}
    }
