package com.team1.mohaji.controller.mainController;

import com.team1.mohaji.dto.SubjectDto;
import com.team1.mohaji.service.main.RegCourseService;

import com.team1.mohaji.service.main.imple.RegCourseServiceImple;
import org.springframework.beans.factory.annotation.Autowired;
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
    public  String regCourse(Model model){
//        log.info("컨트롤러 도착");
        model.addAttribute("regCourseList",regCourseServiceImple.selectAllSubject());
        System.out.println(regCourseServiceImple.selectAllSubject());
//        log.info("컨트롤러 서비스완료 ");
        return "view/regCourse";
    }
    @PostMapping("/search")
    @ResponseBody
    public List<SubjectDto> regCourseSearch(@RequestParam("category") String category, @RequestParam("keyword") String keyword){
        System.out.println("검색으로 오긴왔다"+category+keyword);
        List<SubjectDto> list;
        // 카테고리가 "all"이거나 키워드가 없는 경우
        if ("all".equals(category) && (keyword == null || keyword.isEmpty())) {
            System.out.println("1번"+category+keyword);
            list = regCourseServiceImple.selectAllSubject();
            return list;
        }
        // 카테고리가 "all"이 아니고 키워드가 없는경우
        else if (!"all".equals(category) && (keyword == null || keyword.isEmpty())){
            System.out.println("2번"+category+keyword);
            list = regCourseServiceImple.selectCategory(category);
            return list;
        }
        // 카테고리가 모두 존재할때
        else if(category !=null && !"all".equals(category)&& keyword !=null) {
            System.out.println("3번" + category + keyword);
            list = regCourseServiceImple.selectAllSearch(category, keyword);
            System.out.println(list);
            return list;
        }
        else if("all".equals(category) && (keyword != null )) {
            list = regCourseServiceImple.selectKeyword (keyword);
            System.out.println(list);
            return list;
        }
        // 모델에 추가된 속성을 이용하여 검색 결과를 표시할 뷰로 리다이렉트합니다.
        return new ArrayList<>();
    }


//    @PostMapping("/search")
//    public String regCourseSearch(Model model, @RequestParam("category") String category, @RequestParam("keyword") String keyword){
//        System.out.println("검색으로 오긴왔다"+category+keyword);
//        // 카테고리가 "all"이거나 키워드가 없는 경우
//        if ("all".equals(category) && (keyword == null || keyword.isEmpty())) {
//            System.out.println("1번"+category+keyword);
//            model.addAttribute("regCourseList", regCourseService.selectAllSubject());}
//        // 카테고리가 "all"이 아니고 키워드가 없는경우
//        else if (!"all".equals(category) && (keyword == null || keyword.isEmpty())){
//            System.out.println("2번"+category+keyword);
//            model.addAttribute("regCourseList", regCourseService.selectCategory(category));}
//        // 카테고리가 모두 존재할때
//        else if(category !=null && keyword !=null) {
//            System.out.println("3번"+category+keyword);
//            model.addAttribute("regCourseList", regCourseService.selectAllSearch(category,keyword));
//            List<SubjectDto> list =regCourseService.selectAllSearch(category,keyword);
//            System.out.println(list);
//        }
//        // 모델에 추가된 속성을 이용하여 검색 결과를 표시할 뷰로 리다이렉트합니다.
//        return "/view/regCourse";
//    }

    @GetMapping("/courseDetailPage")
    public String courseDetailPage(){
        return "/view/modalPop/courseDetail";
    }

}
