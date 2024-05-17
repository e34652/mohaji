package com.team1.mohaji.repository;

import com.team1.mohaji.entity.Board.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {
    Comment save(Comment comment);
}
