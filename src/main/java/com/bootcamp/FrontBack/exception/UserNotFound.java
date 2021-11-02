package com.bootcamp.FrontBack.exception;

public class UserNotFound extends RuntimeException {

    public UserNotFound() {
        super("User not found");     }


    public UserNotFound(String message) {
        super(message);
    }
}
