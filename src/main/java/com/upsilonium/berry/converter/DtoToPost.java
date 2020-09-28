package com.upsilonium.berry.converter;

import com.upsilonium.berry.dto.post.PostDto;
import com.upsilonium.berry.model.Post;
import com.upsilonium.berry.service.AuthService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

/**
 * @author Yannick Van Ham
 * created on Sunday, 27/09/2020
 */
@Component
public class DtoToPost implements Converter<PostDto, Post> {
    private final AuthService authService;

    public DtoToPost(AuthService authService) {
        this.authService = authService;
    }

    @Override
    public Post convert(PostDto postDto) {
        Post post = new Post();
        post.setId(postDto.getId());
        post.setTitle(postDto.getTitle());
        post.setContent(postDto.getContent());
        User user = authService.getCurrentUser()
                .orElseThrow(() -> new IllegalArgumentException("No User logged in"));
        post.setUsername(user.getUsername());
        return post;
    }
}
