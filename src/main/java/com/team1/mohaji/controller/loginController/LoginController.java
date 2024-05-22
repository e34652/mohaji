package com.team1.mohaji.controller.loginController;

import com.team1.mohaji.dto.PostDto;
import com.team1.mohaji.entity.Post;
import com.team1.mohaji.service.board.BoardService;
import com.team1.mohaji.service.board.PostService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@Slf4j
public class LoginController {

    @Autowired
    private PostService postService;

    @GetMapping(value={"/",  "/main"})
        public String getMypage(Model model, Authentication authentication){

        List<PostDto> notice = postService.memberName(1);;
        model.addAttribute("notice", notice);
        List<PostDto> assignment = postService.memberName(2);
        model.addAttribute("assignment", assignment);

        if(authentication != null) {
            model.addAttribute("username", authentication.getName());
            model.addAttribute("role", authentication.getAuthorities().toString());

            //혜빈님 코드 추가
        }
        return "view/main";
    }



}
