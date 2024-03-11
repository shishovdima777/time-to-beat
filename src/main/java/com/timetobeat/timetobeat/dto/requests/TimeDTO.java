package com.timetobeat.timetobeat.dto.requests;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class TimeDTO {
    @NotNull
    @Min(0)
    private Integer gameId;
    @NotNull
    @Min(value = 0, message = "minimum value 0")
    @Max(value = 400, message = "maximum value 400")
    @Column(name = "avg_main_story_hours")
    private Integer mainStoryHours;
    @NotNull
    @Min(value = 0, message = "minimum value 0")
    @Max(value = 400, message = "maximum value 400")
    @Column(name = "avg_main_story_hours")
    private Integer mainStoryMinutes;
    @NotNull
    @Min(value = 0, message = "minimum value 0")
    @Max(value = 400, message = "maximum value 400")
    @Column(name = "avg_main_story_hours")
    private Integer completionistHours;
    @NotNull
    @Min(value = 0, message = "minimum value 0")
    @Max(value = 400, message = "maximum value 400")
    @Column(name = "avg_main_story_hours")
    private Integer completionistMinutes;
    @NotNull
    @Min(value = 0, message = "minimum value 0")
    @Max(value = 400, message = "maximum value 400")
    @Column(name = "avg_main_story_hours")
    private Integer mainPlusDlcHours;
    @NotNull
    @Min(value = 0, message = "minimum value 0")
    @Max(value = 400, message = "maximum value 400")
    @Column(name = "avg_main_story_hours")
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
