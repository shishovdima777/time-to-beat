package com.timetobeat.timetobeat.dto;

public class GameImageDTO {
    private Integer id;
    private String url;
    private Integer game;
    public GameImageDTO() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getGame() {
        return game;
    }

    public void setGame(Integer game) {
        this.game = game;
    }

}
