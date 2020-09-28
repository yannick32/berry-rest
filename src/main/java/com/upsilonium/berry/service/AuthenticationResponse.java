package com.upsilonium.berry.service;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Yannick Van Ham
 * created on Monday, 28/09/2020
 */

@Data
@AllArgsConstructor
public class AuthenticationResponse {
    public String authenticationToken;
    private String username;
}
