package com.team1.mohaji.controller.mainController;

import com.team1.mohaji.service.main.RegCourseService;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class RegCourseController {
    @Autowired
    RegCourseService regCourseService;

    @GetMapping("/regCourse")
    public  String regCourse(Model model){
        model.addAttribute("regCourseList",regCourseService.selectAllRegCourse());
        return "view/regCourse";
    }

    @GetMapping("/courseDetailPage")
    public String courseDetailPage(){
        return "view/modalPop/courseDetail";
    }

}
