package com.upsilonium.berry.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Yannick Van Ham
 * created on Sunday, 27/09/2020
 */
@Getter
@Setter
public class RegisterRequest {
    private String username;
    private String password;
    private String email;
}
