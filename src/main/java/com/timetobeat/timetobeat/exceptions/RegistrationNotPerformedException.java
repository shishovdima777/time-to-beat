package com.timetobeat.timetobeat.exceptions;

public class RegistrationNotPerformedException extends RuntimeException{
    public RegistrationNotPerformedException(String message) {
        super(message);
    }
}
