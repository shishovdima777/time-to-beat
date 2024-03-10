package com.timetobeat.timetobeat.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.springframework.stereotype.Component;

import java.util.List;

@Entity
@Component
@Table(name = "app_user")
public class User {
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;
    @NotEmpty(message = "Username shouldn't be empty")
    @Pattern(regexp = "^[a-zA-Z0-9_-]+$", message = "Username should contain only Latin letters, numbers,-,_")
    @Size(min = 4, message = "Minimum username length is 4 characters")
    @Size(max = 100, message = "Maximum username length is 100 characters")
    @Column(name = "username")
    private String username;
    @NotEmpty(message = "This field should not be empty")
    @Size(min = 6, message = "Password must be at least 6 symbols")
    @Column(name = "password")
    private String password;
    @NotEmpty(message = "email shouldn't be empty")
    @Size(max = 255, message = "Maximum email length is 100 characters")
    @Pattern(regexp = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", message = "Not valid email")
    @Column(name = "email")
    private String email;
    @Column(name = "role")
    private String role;
    @ManyToMany
    @JoinTable(
            name = "app_user_game",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "game_id")}
    )
    private List<Game> games;

    public User() {

    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User(String username) {
        this.username = username;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Game> getGames() {
        return games;
    }

    public void setGames(List<Game> games) {
        this.games = games;
    }
}
