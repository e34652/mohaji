package com.team1.mohaji.controller.boardController;

import com.team1.mohaji.config.CustomUserDetails;
import com.team1.mohaji.entity.Board;
import com.team1.mohaji.entity.Post;
import com.team1.mohaji.service.board.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Controller
public class BoardController {
    @ModelAttribute
    public void addAttributes(Model model, @AuthenticationPrincipal CustomUserDetails customUserDetails) {
        System.out.println(customUserDetails.getName());
        model.addAttribute("name", customUserDetails.getName());
    }

    @Autowired
    private BoardService boardService;

    @GetMapping("/boardList")
    public String boardList(Model model){
        List<Board> boardList = boardService.selectAll();
        model.addAttribute("boardList", boardList);
        return "view/board/boardList";
    }
    @GetMapping("/assignment")
    public String assignmentList(Model model){
        List<Post> posts = boardService.getPostsByBoardId(2);
        model.addAttribute("posts", posts);
        return "view/board/assignmentBoard";
    }

    @GetMapping("/notice")
    public String noticeList(Model model){
        List<Post> posts = boardService.getPostsByBoardId(1);
        model.addAttribute("posts", posts);
        return "view/board/noticeBoard";
    }



    @GetMapping("/question")
    public String questionList(Model model){
        List<Post> posts = boardService.getPostsByBoardId(3);
        model.addAttribute("posts", posts);
        return "view/board/questionBoard";
    }


    @GetMapping("/resource")
    public String resourceList(Model model){
        List<Post> posts = boardService.getPostsByBoardId(4);
        model.addAttribute("posts", posts);
        return "view/board/resourceBoard";
    }













}
