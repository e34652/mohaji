package com.team1.mohaji.controller.myPageController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class courseListController {



    @GetMapping("/regList")
    public String myList() {
        return "view/myPage/regList";
    }

}
