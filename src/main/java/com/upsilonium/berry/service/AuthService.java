package com.upsilonium.berry.service;

import com.upsilonium.berry.dto.RegisterRequest;
import com.upsilonium.berry.model.User;
import com.upsilonium.berry.repository.UserRepository;
import org.springframework.stereotype.Service;

/**
 * @author Yannick Van Ham
 * created on Sunday, 27/09/2020
 */
@Service
public class AuthService {
    private UserRepository userRepo;

    public AuthService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    public void signUp(RegisterRequest registerRequest) {
        User user = new User();
        user.setUsername(registerRequest.getUsername());
        user.setPassword(registerRequest.getPassword());
        user.setEmail(registerRequest.getEmail());

        userRepo.save(user);
    }
}
