package com.team1.mohaji.controller.boardController;

import com.team1.mohaji.config.CustomUserDetails;
import com.team1.mohaji.dto.PostDto;
import com.team1.mohaji.entity.Board;
import com.team1.mohaji.entity.Member;
import com.team1.mohaji.entity.Post;
import com.team1.mohaji.model.model;
import com.team1.mohaji.repository.BoardRepository;
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
import java.util.Optional;

@Controller
@Slf4j
public class PostController {


    @Autowired
    private BoardService boardService;

    @Autowired
    private PostService postService;

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private BoardRepository boardRepository;

    @GetMapping("/write")
    public String write(@RequestParam("boardId") int boardId,Model model){
        Optional<Board> optionalBoard = boardRepository.findById(boardId);
        if (optionalBoard.isPresent()) {
            Board board = optionalBoard.get();
            String boardName = board.getBoardName();
            model.addAttribute("boardId", boardId);
            model.addAttribute("boardName", boardName);
        }
        return "view/board/writeForm";
    }


    @PostMapping("/newPost")
    public String insertPost(@RequestParam("boardId") int boardId,
                             @RequestParam("title") String title,
                             @RequestParam("content") String content,
                             @RequestParam("files") List<MultipartFile> files,
                             @AuthenticationPrincipal CustomUserDetails customUserDetails,
                             Model model){

        String boardName = boardService.getBoardName(boardId);
        int memberId = customUserDetails.getMemberId();
        String userRole = customUserDetails.getRole();

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

        return "redirect:/" +boardName;

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
    public String postDetail(@RequestParam("postId") Integer postId, Model model) {
        postService.incrementPostViews(postId);
        PostDto postDto = postService.getPostDetail(postId);
        model.addAttribute("post", postDto);
        return "view/board/postDetail";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Post updatedPost) {
        postService.updatePost(updatedPost);
        return "redirect:/postDetail?postId=" + updatedPost.getPostId();
    }

    @PostMapping("/delete")
    public String delete(@RequestParam("postId") int postId) {
        PostDto postDto = postService.getPostDetail(postId);
        String boardName = boardService.getBoardName(postDto.getBoardId());
        postService.deletePost(postId);
        return "redirect:/" + boardName;
    }

}