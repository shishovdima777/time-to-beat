package com.timetobeat.timetobeat.dto.responses;

public class LoginResponseDTO {
    private String authToken;
    private String message;
    private String username;

    public LoginResponseDTO(String authToken, String message, String username) {
        this.authToken = authToken;
        this.message = message;
        this.username = username;
    }

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
