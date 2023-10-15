package com.timetobeat.timetobeat.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "game")
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "game_id")
    private int gameId;
    @Column(name = "game_name")
    private String gameName;
    @ManyToMany(mappedBy = "games")
    private List<Gamer> gamerList;

    public Game() {

    }

    public Game(String gameName) {
        this.gameName = gameName;
    }

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public List<Gamer> getGamerList() {
        return gamerList;
    }

    public void setGamerList(List<Gamer> gamerList) {
        this.gamerList = gamerList;
    }

}
