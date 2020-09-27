package com.upsilonium.berry.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Yannick Van Ham
 * created on Sunday, 27/09/2020
 */
@Getter
@Setter
public abstract class UserRequest {
    private String username;
    private String password;
}
