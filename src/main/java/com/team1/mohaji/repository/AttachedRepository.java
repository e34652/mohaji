package com.team1.mohaji.repository;

import com.team1.mohaji.entity.Attached;
import com.team1.mohaji.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AttachedRepository extends JpaRepository<Attached, Integer> {
    List<Attached> findByPost(Post post);
}
