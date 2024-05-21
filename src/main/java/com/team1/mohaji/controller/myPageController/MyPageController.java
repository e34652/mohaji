package com.team1.mohaji.controller.myPageController;



import com.team1.mohaji.config.CustomUserDetails;
import com.team1.mohaji.dto.myPage.CreditDto;
import com.team1.mohaji.dto.myPage.MyPCDto;
import com.team1.mohaji.dto.myPage.RegListDto;
import com.team1.mohaji.service.myPage.imple.MyPCSericeImple;
import com.team1.mohaji.service.myPage.imple.RegInfoServiceImple;
import com.team1.mohaji.service.myPage.imple.RegListServiceImple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequestMapping("/myPage")
public class MyPageController {


    @Autowired
    private RegListServiceImple regListServiceImple;
    @Autowired
    private MyPCSericeImple myPCSericeImple;
    @Autowired
    private RegInfoServiceImple regInfoServiceImple;

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


    @GetMapping("/myPC")
    public String showRegistrationPage(Model model, @AuthenticationPrincipal CustomUserDetails customUserDetails) {
        List<MyPCDto> myPCList = myPCSericeImple.selectIP(customUserDetails.getMemberId());
        model.addAttribute("myPCList", myPCList);
        System.out.println("여기도착완료" + myPCList);
        return "/view/myPage/myPC2";
    }

    @RequestMapping("/regInfo")
    public String regInfo(Model model, @AuthenticationPrincipal CustomUserDetails customUserDetails) {
            if(customUserDetails != null) {
                int memberId = customUserDetails.getMemberId();
                //신청기간중인 것
                model.addAttribute("regInfo", regInfoServiceImple.selectRegInfoBF(memberId));
                //신청기간 지난것
                model.addAttribute("regInfo2",regInfoServiceImple.selectRegInfoAT(memberId) );

                model.addAttribute("memberId", memberId);
                return "/view/myPage/regInfo";
            }
            return"redirect:/login";
//        log.info("컨트롤러 서비스완료 ");

        }

    @GetMapping("/regStudy")
    public String regStudy() {
        return "/view/myPage/regStudy";
    }

    @GetMapping("/regResult")
    public String regResult() {
        return "/view/myPage/regResult";
    }

//    내정보
    @GetMapping("/userInfo")
    public String userInfo() {
        return "/view/myPage/userInfo";
    }

    @GetMapping("/userPsUpdate")
    public String userPsUpdate() {
        return "/view/myPage/userPsUpdate";
    }

    }
