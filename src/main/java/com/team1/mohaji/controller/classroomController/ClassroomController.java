package com.team1.mohaji.controller.classroomController;



import com.team1.mohaji.dto.Classroom.ClassroomHomeDto;
import com.team1.mohaji.model.model;
import com.team1.mohaji.service.Classroom.imple.ClassroomHomeHomeServiceImple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
@RequestMapping("/classroom")
public class ClassroomController {

    @Autowired
    private ClassroomHomeHomeServiceImple classroomHomeServiceImple;

    @GetMapping("/home")
        public String myList (
                @AuthenticationPrincipal UserDetails userDetails,
                @RequestParam int subId,
                @RequestParam int memberId,
                Model model){
            if (userDetails != null) {
                List<ClassroomHomeDto> home = classroomHomeServiceImple.sessionListInProgress(subId,memberId);
                model.addAttribute("home", home);
                System.out.println(home);
                return "/view/classroom/classroomHome";
            } else {
                return "redirect:/login";
            }
        }
    @GetMapping("/viewer")
    public String myList (){
            return "/view/classroom/viewer";
        }
    }

