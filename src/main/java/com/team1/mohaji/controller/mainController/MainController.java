package com.team1.mohaji.controller.mainController;

import com.team1.mohaji.config.CustomUserDetails;
import com.team1.mohaji.entity.Post;
import com.team1.mohaji.service.board.BoardService;
import com.team1.mohaji.service.main.RegCourseService;
import com.team1.mohaji.service.main.imple.RegCourseServiceImple;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@Slf4j
public class MainController {


    @GetMapping("/login/login")
    public String showLoginPage() {
        return "view/loginPage/login"; // `login.html` 파일을 반환합니다.
    }

    @GetMapping("/info")
    public String info(Model model, @AuthenticationPrincipal CustomUserDetails customUserDetails){
        model.addAttribute("name",customUserDetails.getName());
        return "/view/info";
    }

}
