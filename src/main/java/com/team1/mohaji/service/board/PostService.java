package com.team1.mohaji.service.board;

import com.team1.mohaji.config.FileStorageProperties;
import com.team1.mohaji.dto.PostDto;
import com.team1.mohaji.entity.Attached;
import com.team1.mohaji.entity.Post;
import com.team1.mohaji.repository.AttachedRepository;
import com.team1.mohaji.repository.BoardRepository;
import com.team1.mohaji.repository.MemberRepository;
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
import java.time.LocalDateTime;
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
    private MemberRepository memberRepository;

    @Autowired
    private BoardService boardService;



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
                    String fileType = file.getContentType();
                    Long fileSize = file.getSize();

                    Files.copy(file.getInputStream(), targetLocation);

                    Attached attached = new Attached();
                    attached.setOriginalName(originalFileName);
                    attached.setSavedName(saveFileName);
                    attached.setAttachedType(fileType);
                    attached.setAttachedSize(fileSize);
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

    public void update(Post updatedPost) {
        // 업데이트된 게시글의 ID를 사용하여 원본 게시글을 불러옴
        Post originalPost = postRepository.findById(updatedPost.getPostId()).orElseThrow(() -> new IllegalArgumentException("Invalid post ID"));

        if (updatedPost.getTitle() != null) {
            originalPost.setTitle(updatedPost.getTitle());
        }
        if (updatedPost.getContent() != null) {
            originalPost.setContent(updatedPost.getContent());
        }
        // 업데이트된 정보 설정
        originalPost.setUpdatedAt(LocalDateTime.now());
        // 업데이트된 정보를 저장
        postRepository.save(originalPost);
    }

    public List<PostDto> memberName(int boardId){
        List<Post> posts = boardService.getPostsByBoardId(boardId);
        List<PostDto> postDtos = new ArrayList<>();
        for(Post post : posts){
            String name = memberRepository.findMemberNameByMemberId(post.getMemberId());
            PostDto postDto = new PostDto();
            postDto.setPostId(post.getPostId());
            postDto.setTitle(post.getTitle());
            postDto.setViews(post.getViews());
            postDto.setCreatedAt(post.getCreatedAt());
            postDto.setMemberId(post.getMemberId());
            postDto.setContent(post.getContent());
            postDto.setMemberName(name);
            postDtos.add(postDto);
        }
        return postDtos;
    }

}
