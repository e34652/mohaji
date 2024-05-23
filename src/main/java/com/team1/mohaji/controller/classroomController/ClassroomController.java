package com.team1.mohaji.controller.classroomController;

import com.team1.mohaji.config.CustomUserDetails;
import com.team1.mohaji.dto.classroom.*;
import com.team1.mohaji.dto.myPage.MyPCDto;
import com.team1.mohaji.service.classroom.imple.AssignmentRoomServiceImple;
import com.team1.mohaji.service.classroom.imple.HomeServiceImple;
import com.team1.mohaji.service.classroom.imple.ViewerServiceImple;
import com.team1.mohaji.service.myPage.imple.MyPCSericeImple;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
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
    @Autowired
    private AssignmentRoomServiceImple assignmentRoomServiceImple;

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
            @RequestParam int memberId, Model model,
            HttpSession session) {
        if (userDetails != null) {
            session.setAttribute("subId", subId);
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

    @GetMapping("/assignmentRoom")
    public String asgnRoom(@AuthenticationPrincipal CustomUserDetails userDetails,
                           Model model, HttpSession session) {
        if (userDetails != null) {
            int memberId = userDetails.getMemberId();
            int subId = (int) session.getAttribute("subId");
            List<AssignmentDto> asgnList = assignmentRoomServiceImple.selectAssignmentList(memberId);
            String subName = assignmentRoomServiceImple.selectSubName(subId);
            model.addAttribute("asgnList", asgnList);
            model.addAttribute("subName",subName);
            System.out.println(asgnList);
            return "view/classroom/assignmentRoom";
        }
        return"redirect:/login";
    }

    @GetMapping("/assignmentDetail")
    public String asgnDetail(@AuthenticationPrincipal CustomUserDetails userDetails,
                             @RequestParam int asgnId, Model model,HttpSession session){
        if (userDetails != null) {
            if (assignmentRoomServiceImple.countRegAsgn(userDetails.getMemberId(), (Integer) session.getAttribute("subId"), asgnId) == 1){
                RegAssignmentDto regAssignmentDto = assignmentRoomServiceImple.selectRegAsgn(userDetails.getMemberId(), (Integer) session.getAttribute("subId"), asgnId);
                model.addAttribute("regAsgn", regAssignmentDto);
                System.out.println(regAssignmentDto);
            }
            AssignmentDto asgn = assignmentRoomServiceImple.selectAssignment(asgnId);
            model.addAttribute("asgn", asgn);
            return "view/classroom/assignmentDetail";
        }
        return"redirect:/login";
    }

    @ResponseBody
    @PostMapping("/submitAsgn")
    public void submitAsgn(@AuthenticationPrincipal CustomUserDetails userDetails,
                           HttpSession session, @ModelAttribute RegAssignmentDto regAssignmentDto) {
        int memberId = userDetails.getMemberId();
        int subId = (Integer)session.getAttribute("subId");
        regAssignmentDto.setMemberId(memberId);
        regAssignmentDto.setSubId(subId);
        if (userDetails != null) {
            if (assignmentRoomServiceImple.countRegAsgn(regAssignmentDto.getMemberId(), regAssignmentDto.getSubId(), regAssignmentDto.getAsgnId()) == 1){
                assignmentRoomServiceImple.updateRegAsgn(regAssignmentDto);
            }else{
                assignmentRoomServiceImple.insertRegAsgn(regAssignmentDto);
            }
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

