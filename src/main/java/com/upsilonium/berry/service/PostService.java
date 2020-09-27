package com.upsilonium.berry.service;

import com.upsilonium.berry.dto.PostDto;
import com.upsilonium.berry.model.Post;
import com.upsilonium.berry.repository.PostRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.time.Instant;

/**
 * @author Yannick Van Ham
 * created on Sunday, 27/09/2020
 */
@Service
public class PostService {
    private final AuthService authService;
    private final PostRepository postRepo;

    public PostService(AuthService authService, PostRepository postRepo) {
        this.authService = authService;
        this.postRepo = postRepo;
    }

    public void createPost(PostDto postDto){
        Post post = new Post();
        post.setTitle(postDto.getTitle());
        post.setContent(postDto.getContent());
        User user = authService.getCurrentUser()
                .orElseThrow(() -> new IllegalArgumentException("No User logged in"));
        post.setUsername(user.getUsername());
        post.setCreationTimestamp(Instant.now());
        postRepo.save(post);
    }
}
