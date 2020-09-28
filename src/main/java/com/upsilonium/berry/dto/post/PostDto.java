package com.upsilonium.berry.dto.post;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Yannick Van Ham
 * created on Sunday, 27/09/2020
 */
@Getter
@Setter
public class PostDto {
    private Long id;
    private String title;
    private String content;
    private String username;
}
