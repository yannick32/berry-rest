package com.upsilonium.berry.exception;

/**
 * @author Yannick Van Ham
 * created on Sunday, 27/09/2020
 */
public class PostNotFoundException extends RuntimeException {
    public PostNotFoundException(String message) {
        super(message);
    }
}
