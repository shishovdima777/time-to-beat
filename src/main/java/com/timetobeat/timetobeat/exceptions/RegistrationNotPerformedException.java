package com.timetobeat.timetobeat.exceptions;
import java.util.Map;

public class RegistrationNotPerformedException extends RuntimeException{
    private Map<String, String> errorMap;
    public RegistrationNotPerformedException(Map<String, String> errorMap) {
       this.errorMap = errorMap;
    }

    public Map<String, String> getErrorMap() {
        return errorMap;
    }

    public void setErrorMap(Map<String, String> errorMap) {
        this.errorMap = errorMap;
    }
}
