package com.team1.mohaji.controller;

import com.team1.mohaji.config.CustomUserDetails;
import com.team1.mohaji.entity.Board;
import com.team1.mohaji.entity.Post;
import com.team1.mohaji.service.imple.BoardService;
import com.team1.mohaji.service.imple.PostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@Slf4j
public class PostController {

    @Autowired
    private BoardService boardService;

    @Autowired
    private PostService postService;

    @GetMapping("/write")
    public String write(Model model){
        List<Board> boardList = boardService.selectAll();
        model.addAttribute("boardList", boardList);
        return "/view/board/writeForm";
    }

    @PostMapping("/newPost")
    public String insertPost(@RequestParam("boardId") int boardId,
                             @RequestParam("title") String title,
                             @RequestParam("content") String content,
                             Model model,
                             @AuthenticationPrincipal CustomUserDetails customUserDetails,
                             MultipartHttpServletRequest multipartHttpServletRequest) {

        int memberId = customUserDetails.getMemberId();
        List<Board> boardList = boardService.selectAll();
        model.addAttribute("boardList", boardList);
        Post newPost = new Post();
        Board board = new Board();
        board.setBoardId(boardId);
        newPost.setTitle(title);
        newPost.setContent(content);
        newPost.setMemberId(memberId);
        newPost.setBoard(board);
        LocalDateTime createdAt = LocalDateTime.now();
        newPost.setCreatedAt(createdAt);

        postService.insertPost(newPost, multipartHttpServletRequest);

        return "/view/board/boardList";
    }

    @GetMapping("/postDetail")
    public String  postDetail(@RequestParam("postId") Integer postId, Model model){
        postService.incrementPostViews(postId);
        Post post = postService.getPostsByPostId(postId);
        log.info(String.valueOf(post));
        model.addAttribute("post", post);
        return "view/board/postDetail";
    }

    @PostMapping("/update")
    public String update(Model model, Post post){
        Post upPost = new Post();
        upPost.getPostId();
        postService.update(post);
        model.addAttribute("post", post);
        return "/view/board/boardList";
    }

    @PostMapping("/delete")
    public String delete(int postId){
        postService.deletePost(postId);
        return "/view/board/boardList";
    }

}