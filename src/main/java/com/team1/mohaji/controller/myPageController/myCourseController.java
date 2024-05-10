package com.team1.mohaji.controller.myPageController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class myCourseController {

    ///myPage/main
    @GetMapping("/a")
    public String myCourse(){
        return "view/main";
    }

    @GetMapping("courseReg")
    public  String coutseReg(){
        return "view/courseReg";
    }
    @GetMapping("/regList")
        public String myList(){
        return "view/myPage/regList";
    }

    @GetMapping("/courseDetailPage")
    public String courseDetailPage(){
        return "view/modalPop/courseDetail";
    }
}
