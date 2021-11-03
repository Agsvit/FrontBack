package com.bootcamp.FrontBack.exception;

public class UpdateUserException extends RuntimeException {
    private String message;

    public UpdateUserException(String message) {
        super(message);
        this.message = message;
    }
}
