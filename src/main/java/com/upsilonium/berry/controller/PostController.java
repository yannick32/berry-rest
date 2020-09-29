package com.upsilonium.berry.controller;

import com.upsilonium.berry.dto.post.PostDto;
import com.upsilonium.berry.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Yannick Van Ham
 * created on Sunday, 27/09/2020
 */
@RestController
@RequestMapping("/api/posts")
public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping
    public ResponseEntity<String> createPost(@RequestBody PostDto postDto){
        postService.createPost(postDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<PostDto>> showAllPosts() {
        return new ResponseEntity<>(postService.showAllPosts(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostDto> showPostWithId(@PathVariable("id") @RequestBody Long id) {
        return new ResponseEntity<>(postService.findById(id), HttpStatus.OK);
    }
}
