package com.upsilonium.berry.service;

import com.upsilonium.berry.dto.RegisterRequest;
import com.upsilonium.berry.model.User;
import com.upsilonium.berry.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author Yannick Van Ham
 * created on Sunday, 27/09/2020
 */
@Service
public class AuthService {
    private final UserRepository userRepo;
    private final PasswordEncoder passwordEncoder;

    public AuthService(UserRepository userRepo, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }

    public void signUp(RegisterRequest registerRequest) {
        User user = new User();
        user.setUsername(registerRequest.getUsername());
        user.setPassword(encodePassword(registerRequest.getPassword()));
        user.setEmail(registerRequest.getEmail());

        userRepo.save(user);
    }

    private String encodePassword(String password) {
        return passwordEncoder.encode(password);
    }
}
