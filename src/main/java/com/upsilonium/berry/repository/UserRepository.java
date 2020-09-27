package com.upsilonium.berry.repository;

import com.upsilonium.berry.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author Yannick Van Ham
 * created on Sunday, 27/09/2020
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
