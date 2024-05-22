package com.team1.mohaji.controller.classroomController;

import com.team1.mohaji.config.CustomUserDetails;
import com.team1.mohaji.dto.classroom.HomeDto;
import com.team1.mohaji.dto.classroom.RegSessionDto;
import com.team1.mohaji.dto.classroom.ViewerDto;
import com.team1.mohaji.dto.myPage.MyPCDto;
import com.team1.mohaji.service.classroom.imple.HomeServiceImple;
import com.team1.mohaji.service.classroom.imple.ViewerServiceImple;
import com.team1.mohaji.service.myPage.imple.MyPCSericeImple;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;


@Controller
@RequestMapping("/classroom")
public class ClassroomController {
    @ModelAttribute
    public void addAttributes(Model model, @AuthenticationPrincipal CustomUserDetails customUserDetails) {
        System.out.println(customUserDetails.getName());
        model.addAttribute("name", customUserDetails.getName());
    }

    @Autowired
    private HomeServiceImple homeServiceImple;
    @Autowired
    private ViewerServiceImple viewerServiceImple;
    @Autowired
    private MyPCSericeImple myPCSericeImple;

    @GetMapping("/home")
    public String myList(
            @AuthenticationPrincipal UserDetails userDetails,
            @RequestParam int subId,
            @RequestParam int memberId, Model model) {
        if (userDetails != null) {
            List<HomeDto> home = homeServiceImple.sessionListInProgress(subId, memberId);
            model.addAttribute("home", home);
            return "view/classroom/classroomHome";
        } else {
            return "redirect:/login";
        }
    }

    @GetMapping("/viewer")
    public String viewerInfo(HttpServletRequest request,
                             @AuthenticationPrincipal CustomUserDetails userDetails,
                             @RequestParam int subId,
                             RedirectAttributes redirectAttributes,
                             @RequestParam int sessionId, Model model) {

//      지현-  ip 체크 코드 추가
        String ipAddress = request.getHeader("X-Forwarded-For");
        if (ipAddress == null || ipAddress.isEmpty()) {
            ipAddress = request.getRemoteAddr();
        }
        List<MyPCDto> myPCList = myPCSericeImple.selectIP(userDetails.getMemberId());
        String finalIpAddress = ipAddress;
        boolean ipMatch = myPCList.stream().anyMatch(pc -> pc.getMipIp().equals(finalIpAddress));
        if (!ipMatch) {
            redirectAttributes.addFlashAttribute("message", "등록되지 않은 PC 입니다");
            // 이전 페이지로 돌아가도록 처리
            String referer = request.getHeader("Referer");
            if (referer != null) {
                return "redirect:" + referer;
            } else {
                // 이전 페이지 정보가 없으면 홈페이지 또는 특정 페이지로 이동하도록 처리
                return "redirect:/classroom/home";
            }
        }


        if (userDetails != null) {
            ViewerDto viewerDto = viewerServiceImple.selectViewerInfo(subId, userDetails.getMemberId(), sessionId);
            model.addAttribute("viewer", viewerDto);
            System.out.println(viewerDto);
            return "view/classroom/viewer";
        }
        return"redirect:/login";
    }
    @ResponseBody
    @PostMapping("/renewRegSession")
    public void renewRegSession(@RequestBody RegSessionDto regSessionDto) {
        System.out.println(regSessionDto);
        viewerServiceImple.renewRegSession(regSessionDto);
        System.out.println("갱신완료");
    }
}

