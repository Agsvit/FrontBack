package com.bootcamp.FrontBack.exception;

public class InvalidPassword extends RuntimeException {

    public InvalidPassword() {
        super("Invalid password");     }


    public InvalidPassword(String message) {
        super(message);
    }
}
