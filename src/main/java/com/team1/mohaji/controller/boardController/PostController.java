package com.team1.mohaji.controller.boardController;

import com.team1.mohaji.config.CustomUserDetails;
import com.team1.mohaji.entity.Board;
import com.team1.mohaji.entity.Member;
import com.team1.mohaji.entity.Post;
import com.team1.mohaji.model.model;
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
    @ModelAttribute
    public void addAttributes(Model model, @AuthenticationPrincipal CustomUserDetails customUserDetails) {
        System.out.println(customUserDetails.getName());
        model.addAttribute("name", customUserDetails.getName());
    }

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
        String userRole = customUserDetails.getRole();
        System.out.println(memberId);
        System.out.println(userRole);
        // 권한 검증 로직
        boolean hasPermission = checkPermission(boardId, userRole);
        if (!hasPermission) {
            return "/view/error"; // 권한이 없을 경우 /error 페이지로 포워드
        }

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

    private boolean checkPermission(int boardId, String userRole) {
        switch (boardId) {
            case 1: // 관리자만
                return "ADMIN".equals(userRole);
            case 2: // 교수만
                return "PROFESSOR".equals(userRole);
            case 3: // 누구나
                return true;
            case 4: // 누구나
                return true;
            default:
                return false;
        }
    }

    @GetMapping("/postDetail")
    public String  postDetail(@RequestParam("postId") Integer postId, Model model){
        postService.incrementPostViews(postId);
        Post post = postService.getPostsByPostId(postId);
        String memberName = memberRepository.findMemberNameByMemberId(post.getMemberId());
        model.addAttribute("post", post);
        model.addAttribute("memberName", memberName);
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