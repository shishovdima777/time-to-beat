package com.timetobeat.timetobeat.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "gamer")
public class Gamer {
    @Id
    @Column(name = "gamer_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int gamerId;
    @Column(name = "username")
    private String username;
    @ManyToMany
    @JoinTable(
            name = "gamer_game",
            joinColumns = @JoinColumn(name = "gamer_id"),
            inverseJoinColumns = @JoinColumn(name = "game_id")
    )
    private List<Game> games;

    public Gamer() {

    }

    public Gamer(String username) {
        this.username = username;
    }

    public int getGamerId() {
        return gamerId;
    }

    public void setGamerId(int gamerId) {
        this.gamerId = gamerId;
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
