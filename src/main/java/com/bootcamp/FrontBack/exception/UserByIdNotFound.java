package com.bootcamp.FrontBack.exception;

public class UserByIdNotFound extends RuntimeException {
    private String message;

    public UserByIdNotFound(String message) {
        super(message);
        this.message = message;
    }
}
