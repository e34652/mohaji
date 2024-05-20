package com.team1.mohaji.controller.myPageController;



import com.team1.mohaji.config.CustomUserDetails;
import com.team1.mohaji.dto.myPage.CreditDto;
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
@RequestMapping("/myPage")
public class MyPageController {

    @Autowired

    private RegListServiceImple regListServiceImple;

    @GetMapping("/regList")
        public String myList (@AuthenticationPrincipal CustomUserDetails userDetails, Model model){
            if (userDetails != null) {
                int memberId = userDetails.getMemberId();
                List<RegListDto> regList = regListServiceImple.regListInProgress(memberId);
                CreditDto creditDto = regListServiceImple.selectCredits(memberId);
                model.addAttribute("regList", regList);
                model.addAttribute("credit", creditDto);
                System.out.println(regList);
                return "/view/myPage/regList";
            }
            return"redirect:/login";
        }
    }
