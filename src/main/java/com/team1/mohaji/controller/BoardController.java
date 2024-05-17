package com.team1.mohaji.controller;

import com.team1.mohaji.entity.Board.Board;
import com.team1.mohaji.entity.Board.Post;
import com.team1.mohaji.service.imple.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;

    @GetMapping("/boardList")
    public String boardList(Model model){
        List<Board> boardList = boardService.selectAll();
        model.addAttribute("boardList", boardList);
        return "/view/board/boardList";
    }

    @GetMapping("/assignment")
    public String assignmentList(Model model){
        List<Post> posts = boardService.getPostsByBoardId(2);
        model.addAttribute("posts", posts);
        return "/view/board/assignmentBoard";
    }

    @GetMapping("/notice")
    public String noticeList(Model model){
        List<Post> posts = boardService.getPostsByBoardId(1);
        model.addAttribute("posts", posts);
        return "/view/board/noticeBoard";
    }



    @GetMapping("/question")
    public String questionList(Model model){
        List<Post> posts = boardService.getPostsByBoardId(3);
        model.addAttribute("posts", posts);
        return "/view/board/questionBoard";
    }


    @GetMapping("/resource")
    public String resourceList(Model model){
        List<Post> posts = boardService.getPostsByBoardId(4);
        model.addAttribute("posts", posts);
        return "/view/board/resourceBoard";
    }













}
