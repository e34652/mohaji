package com.team1.mohaji.controller.boardController;

import com.team1.mohaji.config.CustomUserDetails;
import com.team1.mohaji.entity.Board;
import com.team1.mohaji.entity.Post;
import com.team1.mohaji.repository.MemberRepository;
import com.team1.mohaji.service.board.BoardService;
import com.team1.mohaji.service.board.PostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

@Controller
@Slf4j
public class PostController {

    @Autowired
    private BoardService boardService;

    @Autowired
    private PostService postService;

    @Autowired
    private MemberRepository memberRepository;

    @GetMapping("/write")
    public String write(Model model){
        List<Board> boardList = boardService.selectAll();
        model.addAttribute("boardList", boardList);
        return "view/board/writeForm";
    }

    @PostMapping("/newPost")
    public String insertPost(@RequestParam("boardId") int boardId,
                             @RequestParam("title") String title,
                             @RequestParam("content") String content,
                             @RequestParam("files") List<MultipartFile> files,
                             @AuthenticationPrincipal CustomUserDetails customUserDetails,
                             Model model){

        int memberId = customUserDetails.getMemberId();

        List<Board> boardList = boardService.selectAll();
        model.addAttribute("boardList", boardList);
        Post newPost = new Post();
        Board board = new Board();
        board.setBoardId(boardId);
        newPost.setTitle(title);
        newPost.setContent(content);
        newPost.setMemberId(memberId);
        newPost.setViews(0);
        newPost.setBoard(board);
        LocalDateTime createdAt = LocalDateTime.now();
        newPost.setCreatedAt(createdAt);
        model.addAttribute("files", files);

        try {
            postService.insertPost(newPost, files, memberId);
        } catch (IOException e) {
            e.printStackTrace();
            // 예외 처리 로직 추가
        }

        return "redirect:/boardList";
    }

    @GetMapping("/postDetail")
    public String  postDetail(@RequestParam("postId") Integer postId, Model model){
        postService.incrementPostViews(postId);
        Post post = postService.getPostsByPostId(postId);
        log.info(String.valueOf(post));
        log.info(post.getAttachments().toString());
        model.addAttribute("post", post);
        return "view/board/postDetail";
    }

    @PostMapping("/update")
    public String update(Post updatedPost) {
        postService.update(updatedPost);
        return "redirect:/postDetail?postId=" + updatedPost.getPostId();
    }

    @PostMapping("/delete")
    public String delete(int postId){
        postService.deletePost(postId);
        return "redirect:/boardList";
    }

}