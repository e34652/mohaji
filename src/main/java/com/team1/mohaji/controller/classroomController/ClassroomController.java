package com.team1.mohaji.controller.classroomController;



import com.team1.mohaji.config.CustomUserDetails;
import com.team1.mohaji.dto.myPage.RegListDto;
import com.team1.mohaji.service.myPage.imple.RegListServiceImple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequestMapping("/classroom")
public class ClassroomController {

    @Autowired
    private RegListServiceImple regListServiceImple;

    @GetMapping("/home")
        public String myList (@AuthenticationPrincipal CustomUserDetails userDetails, Model model){
            if (userDetails != null) {
                int memberId = userDetails.getMemberId();
                List<RegListDto> regList = regListServiceImple.regListInProgress(memberId);
                model.addAttribute("regList", regList);
                System.out.println(regList);
                return "/view/myPage/regList";
            } else {
                throw new NullPointerException("로그인 유저 정보가 없습니다");
            }
        }
    }
