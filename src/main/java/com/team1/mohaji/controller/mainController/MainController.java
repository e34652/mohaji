package com.team1.mohaji.controller.mainController;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
public class MainController {

    @GetMapping("/aa")
    public  String main1()
    {return "/view/main";}

    @GetMapping("/dd")
    public  String main2(){
    return "/view/main";
}

    @Controller
    public static class HomeController {

        @RequestMapping(value={"", "/", "main", "/main"})
        public String displayHomePage() {
            return "/view/main";
        }

    }
}
