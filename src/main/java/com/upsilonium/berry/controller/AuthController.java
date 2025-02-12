package com.upsilonium.berry.controller;

import com.upsilonium.berry.dto.user.LoginRequest;
import com.upsilonium.berry.dto.user.RegisterRequest;
import com.upsilonium.berry.service.AuthService;
import com.upsilonium.berry.service.AuthenticationResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Yannick Van Ham
 * created on Sunday, 27/09/2020
 */
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/signup")
    public ResponseEntity<String> signUp(@RequestBody RegisterRequest registerRequest){
        authService.signUp(registerRequest);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/login")
    public AuthenticationResponse login(@RequestBody LoginRequest loginRequest){
        return authService.login(loginRequest);
    }
}
