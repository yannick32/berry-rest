package com.upsilonium.berry.converter;

import com.upsilonium.berry.dto.PostDto;
import com.upsilonium.berry.model.Post;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * @author Yannick Van Ham
 * created on Sunday, 27/09/2020
 */
@Component
public class PostToDto implements Converter<Post, PostDto> {
    @Override
    public PostDto convert(Post post) {
        PostDto postDto = new PostDto();
        postDto.setId(post.getId());
        postDto.setTitle(post.getTitle());
        postDto.setContent(post.getContent());
        postDto.setUsername(post.getUsername());
        return postDto;
    }
}
