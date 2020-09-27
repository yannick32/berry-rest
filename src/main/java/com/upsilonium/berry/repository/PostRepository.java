package com.upsilonium.berry.repository;

import com.upsilonium.berry.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Yannick Van Ham
 * created on Sunday, 27/09/2020
 */
@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

}
