package com.timetobeat.timetobeat.dto.requests;

public class CredentialsDTO {
    private String username;
    private String password;

    public CredentialsDTO() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
