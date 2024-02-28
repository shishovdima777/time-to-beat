package com.timetobeat.timetobeat.dto.responses;

import com.timetobeat.timetobeat.models.Game;

import java.util.List;

public class UserDTO {
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    private List<Game> games;

    public List<Game> getGames() {
        return games;
    }

    public void setGames(List<Game> games) {
        this.games = games;
    }
}
