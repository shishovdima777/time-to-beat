package com.timetobeat.timetobeat.dto.responses;

public class RegistrationResponseDTO {
    private String authToken;

    public RegistrationResponseDTO(String authToken) {
        this.authToken = authToken;
    }

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }
}
