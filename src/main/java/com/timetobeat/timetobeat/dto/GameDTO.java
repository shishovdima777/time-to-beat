package com.timetobeat.timetobeat.dto;

public class GameDTO {
    private int igdbId;
    private String gameName;
    private String url;
    private Integer avgMainStoryHours;

    private Integer avgMainStoryMinutes;

    private Integer avgCompletionistHours;

    private Integer avgCompletionistMinutes;

    private Integer avgMainPlusDlcHours;

    private Integer avgMainPlusDlcMinutes;

    public int getIgdbId() {
        return igdbId;
    }

    public void setIgdbId(int igdbId) {
        this.igdbId = igdbId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public Integer getAvgMainStoryHours() {
        return avgMainStoryHours;
    }

    public void setAvgMainStoryHours(Integer avgMainStoryHours) {
        this.avgMainStoryHours = avgMainStoryHours;
    }

    public Integer getAvgMainStoryMinutes() {
        return avgMainStoryMinutes;
    }

    public void setAvgMainStoryMinutes(Integer avgMainStoryMinutes) {
        this.avgMainStoryMinutes = avgMainStoryMinutes;
    }

    public Integer getAvgCompletionistHours() {
        return avgCompletionistHours;
    }

    public void setAvgCompletionistHours(Integer avgCompletionistHours) {
        this.avgCompletionistHours = avgCompletionistHours;
    }

    public Integer getAvgCompletionistMinutes() {
        return avgCompletionistMinutes;
    }

    public void setAvgCompletionistMinutes(Integer avgCompletionistMinutes) {
        this.avgCompletionistMinutes = avgCompletionistMinutes;
    }

    public Integer getAvgMainPlusDlcHours() {
        return avgMainPlusDlcHours;
    }

    public void setAvgMainPlusDlcHours(Integer avgMainPlusDlcHours) {
        this.avgMainPlusDlcHours = avgMainPlusDlcHours;
    }

    public Integer getAvgMainPlusDlcMinutes() {
        return avgMainPlusDlcMinutes;
    }

    public void setAvgMainPlusDlcMinutes(Integer avgMainPlusDlcMinutes) {
        this.avgMainPlusDlcMinutes = avgMainPlusDlcMinutes;
    }
}
