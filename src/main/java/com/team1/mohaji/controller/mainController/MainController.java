package com.team1.mohaji.controller.mainController;

import com.team1.mohaji.entity.Post;
import com.team1.mohaji.service.board.BoardService;
import com.team1.mohaji.service.main.RegCourseService;
import com.team1.mohaji.service.main.imple.RegCourseServiceImple;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@Slf4j
public class MainController {

    @Autowired
    private BoardService boardService;

    @RequestMapping("/info")
    public String info(){
        return "view/info";
    }

    //혜빈 갯수 지정 추가
    @RequestMapping(value={"", "/", "main", "/main"})
    public String displayHomePage(Model model) {
        int limit = 5; // 가져올 게시물의 개수
        List<Post> notice = boardService.getPostsPage(1, limit);
        model.addAttribute("notice", notice);
        List<Post> assignment = boardService.getPostsPage(2, limit);
        model.addAttribute("assignment", assignment);
        return "/view/main";
    }

}
