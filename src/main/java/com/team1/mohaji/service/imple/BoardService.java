package com.team1.mohaji.service.imple;

import com.team1.mohaji.entity.Board;
import com.team1.mohaji.entity.Post;
import com.team1.mohaji.repository.BoardRepository;
import com.team1.mohaji.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private PostRepository postRepository;

    public List<Board> selectAll(){
        List<Board> boardList = boardRepository.findAll();
        return boardList;
    }

    public List<Post> getPostsByBoardId(int boardId) {
        return postRepository.findByBoard_BoardId(boardId);
    }

}
