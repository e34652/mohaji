package com.team1.mohaji.service.imple;

import com.team1.mohaji.config.FileStorageProperties;
import com.team1.mohaji.entity.Attached;
import com.team1.mohaji.entity.Post;
import com.team1.mohaji.repository.AttachedRepository;
import com.team1.mohaji.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private AttachedRepository attachedRepository;

    private final Path fileStorageLocation;


    @Autowired
    public PostService(FileStorageProperties fileStorageProperties) {
        this.fileStorageLocation = Paths.get(fileStorageProperties.getUploadDir())
                .toAbsolutePath().normalize();
        try {
            Files.createDirectories(this.fileStorageLocation);
        } catch (Exception ex) {
            throw new RuntimeException("Could not create the directory where the uploaded files will be stored.", ex);
        }
    }

    public List<Post> postList(int postId){
        List<Post> postList = postRepository.findAll();
        return postList;
    }

    private String generateUniqueFileName(String originalFileName) {
        String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        String fileExtension = "";
        int dotIndex = originalFileName.lastIndexOf('.');
        if (dotIndex > 0) {
            fileExtension = originalFileName.substring(dotIndex);
        }

        return timeStamp + "_" + originalFileName + fileExtension;
    }

    @Transactional
     public void insertPost(Post post, List<MultipartFile> files, int memberId) throws IOException {
            List<Attached> attachments = new ArrayList<>();
            for (MultipartFile file : files) {
                if (!file.isEmpty()) {
                    String originalFileName = file.getOriginalFilename();
                    String saveFileName = generateUniqueFileName(originalFileName);
                    Path targetLocation = this.fileStorageLocation.resolve(saveFileName);
                    Files.copy(file.getInputStream(), targetLocation);

                    Attached attached = new Attached();
                    attached.setSavedName(saveFileName);
                    attached.setStoragePath(targetLocation.toString());
                    attached.setPost(post);
                    attached.setMemberId(memberId); // memberId 설정
                    attachments.add(attached);
                }
            }
            post.setAttachments(attachments);
            postRepository.save(post);
            attachedRepository.saveAll(attachments);

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
