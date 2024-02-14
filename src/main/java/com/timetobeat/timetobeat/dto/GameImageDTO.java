package com.timetobeat.timetobeat.dto;

public class GameImageDTO {
    private int id;
    private String url;
    private int game;
    public GameImageDTO() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getGame() {
        return game;
    }

    public void setGame(int game) {
        this.game = game;
    }

}
