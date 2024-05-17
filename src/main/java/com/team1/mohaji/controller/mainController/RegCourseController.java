package com.team1.mohaji.controller.mainController;

import com.team1.mohaji.config.CustomUserDetails;
import com.team1.mohaji.dto.SubjectDto;
import com.team1.mohaji.model.model;
import com.team1.mohaji.service.main.RegCourseService;

import com.team1.mohaji.service.main.imple.RegCourseServiceImple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticatedPrincipal;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
//@Slf4j
public class RegCourseController {

    @Autowired
    RegCourseServiceImple regCourseServiceImple;

    @RequestMapping("/regCourse")
    public  String regCourse(Model model, @AuthenticationPrincipal CustomUserDetails customUserDetails){
//        log.info("컨트롤러 도착");
//        model.addAttribute("regCourseList",regCourseServiceImple.selectAllSubject());
        int memberId= customUserDetails.getMemberId();
        model.addAttribute("regCourseList",regCourseServiceImple.selectSubjectByRegStat(memberId));
        model.addAttribute("memberId", memberId);
        System.out.println(regCourseServiceImple.selectSubjectByRegStat(memberId));

//        log.info("컨트롤러 서비스완료 ");
        return "view/regCourse";
    }

    @GetMapping("/reg")
    public String reg(@RequestParam int memberId, @RequestParam int subId) {
        String rcStat="수강중";
        String stat =regCourseServiceImple.selectRegCourseByRegStat(memberId,subId);
        if(stat != null &&stat.equals("취소") ){
            regCourseServiceImple.updateRegCourse(memberId, subId);
            return "redirect:/regCourse";
        }
            regCourseServiceImple.insertReg(memberId, subId, rcStat);
        // 필요한 로직을 처리한 후 리다이렉트
        return "redirect://regCourse";
    }

    @PostMapping("/search")
    @ResponseBody
    public List<SubjectDto> regCourseSearch(Model model,@AuthenticationPrincipal CustomUserDetails customUserDetails,@RequestParam("category") String category, @RequestParam("keyword") String keyword){
       String memberId = String.valueOf(customUserDetails.getMemberId());
        System.out.println("검색으로 오긴왔다"+category+keyword);
        List<SubjectDto> list;
        // 카테고리가 "all"이거나 키워드가 없는 경우
        if ("all".equals(category) && (keyword == null || keyword.isEmpty())) {
            System.out.println("1번"+category+keyword);
            list = regCourseServiceImple.selectAllSubject(memberId);
            return list;
        }
        // 카테고리가 "all"이 아니고 키워드가 없는경우
        else if (!"all".equals(category) && (keyword == null || keyword.isEmpty())){
            System.out.println("2번"+category+keyword);
            list = regCourseServiceImple.selectCategory(category, memberId);
            return list;
        }
        // 카테고리가 모두 존재할때
        else if(category !=null && !"all".equals(category)&& keyword !=null) {
            System.out.println("3번" + category + keyword);
            list = regCourseServiceImple.selectAllSearch(category, keyword, memberId);
            System.out.println(list);
            return list;
        }
        else if("all".equals(category) && (keyword != null )) {
            list = regCourseServiceImple.selectKeyword (keyword, memberId);
            System.out.println(list);
            return list;
        }
        // 모델에 추가된 속성을 이용하여 검색 결과를 표시할 뷰로 리다이렉트합니다.
        return new ArrayList<>();
    }

    @GetMapping("/courseDetail")
    public String courseDetailPage(){
        return "/view/modalPop/courseDetail";
    }
}
