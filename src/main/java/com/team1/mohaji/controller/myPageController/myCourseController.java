package com.team1.mohaji.controller.myPageController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class myCourseController {

    ///myPage/main
   // @GetMapping("/")
    public String myCourse(){
        return "view/myPage/myPC";
    }

    @GetMapping("/courseDetailPage")
    public String courseDetailPage(){
        return "view/modalPop/courseDetail";
    }
}
