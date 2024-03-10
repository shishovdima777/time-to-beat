package com.timetobeat.timetobeat.dto.requests;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class CredentialsDTO {
    @NotEmpty(message = "Username shouldn't be empty")
    @Pattern(regexp = "^[a-zA-Z0-9_-]+$", message = "Username should contain only Latin letters, numbers,-,_")
    @Size(min = 4, message = "Minimum username length is 4 characters")
    @Size(max = 100, message = "Maximum username length is 100 characters")
    private String username;
    @NotEmpty(message = "This field should not be empty")
    @Size(min = 6, message = "Password must be at least 6 symbols")
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
