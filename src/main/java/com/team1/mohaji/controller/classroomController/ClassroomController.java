package com.team1.mohaji.controller.classroomController;



import com.team1.mohaji.config.CustomUserDetails;
import com.team1.mohaji.dto.classroom.HomeDto;
import com.team1.mohaji.dto.classroom.RegSessionDto;
import com.team1.mohaji.dto.classroom.ViewerDto;
import com.team1.mohaji.service.classroom.imple.HomeServiceImple;
import com.team1.mohaji.service.classroom.imple.ViewerServiceImple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/classroom")
public class ClassroomController {

    @Autowired
    private HomeServiceImple homeServiceImple;
    @Autowired
    private ViewerServiceImple viewerServiceImple;

    @GetMapping("/home")
    public String myList(
            @AuthenticationPrincipal UserDetails userDetails,
            @RequestParam int subId,
            @RequestParam int memberId, Model model) {
        if (userDetails != null) {
            List<HomeDto> home = homeServiceImple.sessionListInProgress(subId, memberId);
            model.addAttribute("home", home);
            return "/view/classroom/classroomHome";
        } else {
            return "redirect:/login";
        }
    }

    @GetMapping("/viewer")
    public String viewerInfo(@AuthenticationPrincipal CustomUserDetails userDetails,
                             @RequestParam int subId,
                             @RequestParam int sessionId, Model model) {
        if (userDetails != null) {
            ViewerDto viewerDto = viewerServiceImple.selectViewerInfo(subId, userDetails.getMemberId(), sessionId);
            model.addAttribute("viewer", viewerDto);
            System.out.println(viewerDto);
            return "/view/classroom/viewer";
        } else {
            return "redirect:/login";
        }
    }
    @ResponseBody
    @PostMapping("/renewRegSession")
    public void renewRegSession(@RequestBody RegSessionDto regSessionDto) {
        System.out.println(regSessionDto);
        viewerServiceImple.renewRegSession(regSessionDto);
        System.out.println("갱신완료");
    }
}

