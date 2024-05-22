package com.team1.mohaji.controller.boardController;

import com.team1.mohaji.config.CustomUserDetails;
import com.team1.mohaji.dto.PostDto;
import com.team1.mohaji.entity.Board;
import com.team1.mohaji.entity.Post;
import com.team1.mohaji.service.board.BoardService;
import com.team1.mohaji.service.board.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Controller
public class BoardController {

    @Autowired
    private PostService postService;

    @ModelAttribute
    public void addAttributes(Model model, @AuthenticationPrincipal CustomUserDetails customUserDetails) {
        if (customUserDetails != null) {
            model.addAttribute("name", customUserDetails.getName());
        }
    }

    @GetMapping("/boardList")
    public String boardList(Model model){
        List<PostDto> postDTOs = postService.memberName(1);
        model.addAttribute("posts", postDTOs);
        return "view/board/noticeBoard";
    }
    @GetMapping("/assignment")
    public String assignmentList(Model model){
        List<PostDto> postDTOs = postService.memberName(2);
        model.addAttribute("posts", postDTOs);
        return "view/board/assignmentBoard";
    }

    @GetMapping("/notice")
    public String noticeList(Model model){
        List<PostDto> postDTOs = postService.memberName(1);
        model.addAttribute("posts", postDTOs);
        return "view/board/noticeBoard";
    }



    @GetMapping("/question")
    public String questionList(Model model){
        List<PostDto> postDTOs = postService.memberName(3);
        model.addAttribute("posts", postDTOs);
        return "view/board/questionBoard";
    }


    @GetMapping("/resource")
    public String resourceList(Model model){
        List<PostDto> postDTOs = postService.memberName(4);
        model.addAttribute("posts", postDTOs);
        return "view/board/resourceBoard";
    }



}