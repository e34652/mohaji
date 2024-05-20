package com.team1.mohaji.controller.mainController;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class courseRegController {

    @GetMapping("/courseReg")
    public  String coutseReg(){
        return "view/courseReg";
    }

    @GetMapping("/courseDetailPage")
    public String courseDetailPage(){
        return "view/modalPop/courseDetail";
    }

}
