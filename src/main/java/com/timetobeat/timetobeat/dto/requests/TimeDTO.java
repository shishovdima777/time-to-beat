package com.timetobeat.timetobeat.dto.requests;

public class TimeDTO {
    private Integer gameId;
    private Integer mainStoryHours;
    private Integer mainStoryMinutes;
    private Integer completionistHours;
    private Integer completionistMinutes;
    private Integer mainPlusDlcHours;
    private Integer mainPlusDlcMinutes;

    public TimeDTO() {
    }
    public TimeDTO(Integer gameId, Integer mainStoryHours, Integer mainStoryMinutes, Integer completionistHours, Integer completionistMinutes, Integer mainPlusDlcHours, Integer mainPlusDlcMinutes) {
        this.gameId = gameId;
        this.mainStoryHours = mainStoryHours;
        this.mainStoryMinutes = mainStoryMinutes;
        this.completionistHours = completionistHours;
        this.completionistMinutes = completionistMinutes;
        this.mainPlusDlcHours = mainPlusDlcHours;
        this.mainPlusDlcMinutes = mainPlusDlcMinutes;
    }

    public Integer getGameId() {
        return gameId;
    }

    public void setGameId(Integer gameId) {
        this.gameId = gameId;
    }

    public Integer getMainStoryHours() {
        return mainStoryHours;
    }

    public void setMainStoryHours(Integer mainStoryHours) {
        this.mainStoryHours = mainStoryHours;
    }

    public Integer getMainStoryMinutes() {
        return mainStoryMinutes;
    }

    public void setMainStoryMinutes(Integer mainStoryMinutes) {
        this.mainStoryMinutes = mainStoryMinutes;
    }

    public Integer getCompletionistHours() {
        return completionistHours;
    }

    public void setCompletionistHours(Integer completionistHours) {
        this.completionistHours = completionistHours;
    }

    public Integer getCompletionistMinutes() {
        return completionistMinutes;
    }

    public void setCompletionistMinutes(Integer completionistMinutes) {
        this.completionistMinutes = completionistMinutes;
    }

    public Integer getMainPlusDlcHours() {
        return mainPlusDlcHours;
    }

    public void setMainPlusDlcHours(Integer mainPlusDlcHours) {
        this.mainPlusDlcHours = mainPlusDlcHours;
    }

    public Integer getMainPlusDlcMinutes() {
        return mainPlusDlcMinutes;
    }

    public void setMainPlusDlcMinutes(Integer mainPlusDlcMinutes) {
        this.mainPlusDlcMinutes = mainPlusDlcMinutes;
    }
}
