package com.team1.mohaji.controller.loginController;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class LoginController {

    @GetMapping("/mypage")
    public String getMypage(Model model, Authentication authentication) {
        if (authentication != null) {
            model.addAttribute("username", authentication.getName());
            model.addAttribute("role", authentication.getAuthorities().toString());
        }
        return "/view/mypage";
    }



}
