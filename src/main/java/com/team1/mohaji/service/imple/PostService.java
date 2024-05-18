package com.team1.mohaji.service.imple;

import com.team1.mohaji.entity.Post;
import com.team1.mohaji.repository.LikeRepository;
import com.team1.mohaji.repository.PostRepository;
import com.team1.mohaji.util.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private LikeRepository likeRepository;

    @Autowired
    private FileUtils fileUtils;

    public List<Post> postList(int postId){
        List<Post> postList = postRepository.findAll();
        return postList;
    }

     public void insertPost(Post post, MultipartHttpServletRequest multipartHttpServletRequest){

     }

    @Transactional
    public int deletePost(int postId){
        int result = postRepository.deleteByPostId(postId);
        return result;
    }

    public Post getPostsByPostId(int postId) {
        Post post = postRepository.findByPostId(postId);
        return post;
    }
    @Transactional
    public void incrementPostViews(Integer postId) {
        postRepository.updateViews(postId);
    }

    public void update(Post post) {
        postRepository.save(post);
    }
}
