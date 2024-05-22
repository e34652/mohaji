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

    @RequestMapping(value={"", "/", "main", "/main"})
    public String displayHomePage(Model model) {
        List<Post> notice = boardService.getPostsByBoardId(1);
        model.addAttribute("notice", notice);
        List<Post> assignment = boardService.getPostsByBoardId(2);
        model.addAttribute("assignment", assignment);
        return "/view/main";
    }

}
