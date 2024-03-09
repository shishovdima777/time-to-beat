package com.timetobeat.timetobeat.exceptions;

public class UserNotExistsException extends RuntimeException{
    private String message;
    public UserNotExistsException(String message) {
        super(message);
    }

}
