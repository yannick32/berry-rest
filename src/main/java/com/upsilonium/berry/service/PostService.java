package com.upsilonium.berry.service;

import com.upsilonium.berry.converter.DtoToPost;
import com.upsilonium.berry.converter.PostToDto;
import com.upsilonium.berry.dto.post.PostDto;
import com.upsilonium.berry.exception.PostNotFoundException;
import com.upsilonium.berry.model.Post;
import com.upsilonium.berry.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * @author Yannick Van Ham
 * created on Sunday, 27/09/2020
 */
@Service
public class PostService {
    private final AuthService authService;
    private final PostRepository postRepo;
    private final PostToDto postToDto;
    private final DtoToPost dtoToPost;

    public PostService(AuthService authService, PostRepository postRepo, PostToDto postToDto, DtoToPost dtoToPost) {
        this.authService = authService;
        this.postRepo = postRepo;
        this.postToDto = postToDto;
        this.dtoToPost = dtoToPost;
    }

    public void createPost(PostDto postDto) {
        Post post = dtoToPost.convert(postDto);
        assert post != null;
        post.setCreationTimestamp(Instant.now());
        postRepo.save(post);
    }

    public List<PostDto> showAllPosts() {
        List<Post> posts = postRepo.findAll();
        return posts.stream()
                .map(postToDto::convert)
                .collect(toList());
    }

    public PostDto findById(Long id) {
        Post post = postRepo.findById(id)
                .orElseThrow(() -> new PostNotFoundException(
                        String.format("Post with id %s not found", id)
                ));
        return postToDto.convert(post);
    }
}
