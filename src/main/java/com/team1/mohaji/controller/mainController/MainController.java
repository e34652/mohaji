package com.team1.mohaji.controller.mainController;

import com.team1.mohaji.service.main.RegCourseService;
import com.team1.mohaji.service.main.imple.RegCourseServiceImple;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
public class MainController {

    @RequestMapping("/info")
    public String info(){
        return "/view/info";
    }

    @Controller
    public static class HomeController {

        @RequestMapping(value={"", "/", "main", "/main"})
        public String displayHomePage() {
            return "/view/main";
        }

    }
}
