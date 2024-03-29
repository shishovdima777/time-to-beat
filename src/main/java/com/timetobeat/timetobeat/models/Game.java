package com.timetobeat.timetobeat.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.NumberFormat;

import java.util.List;

@Entity
@Table(name = "game")
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "game_id")
    private Integer gameId;
    @NotNull
    @Column(name = "igdb_id")
    private Integer igdbId;
    @NotEmpty
    @Column(name = "game_name")
    private String gameName;
    @NotNull
    @Min(value = 0, message = "minimum value 0")
    @Max(value = 400, message = "maximum value 400")
    @Column(name = "avg_main_story_hours")
    private Integer avgMainStoryHours;
    @NotNull
    @Min(value = 0, message = "minimum value 0")
    @Max(value = 400, message = "maximum value 400")
    @Column(name = "avg_main_story_minutes")
    private Integer avgMainStoryMinutes;
    @NotNull
    @Min(value = 0, message = "minimum value 0")
    @Max(value = 400, message = "maximum value 400")
    @Column(name = "avg_completionist_hours")
    private Integer avgCompletionistHours;
    @NotNull
    @Min(value = 0, message = "minimum value 0")
    @Max(value = 400, message = "maximum value 400")
    @Column(name = "avg_completionist_minutes")
    private Integer avgCompletionistMinutes;
    @NotNull
    @Min(value = 0, message = "minimum value 0")
    @Max(value = 400, message = "maximum value 400")
    @Column(name = "avg_main_plus_dlc_hours")
    private Integer avgMainPlusDlcHours;
    @NotNull
    @Min(value = 0, message = "minimum value 0")
    @Max(value = 400, message = "maximum value 400")
    @Column(name = "avg_main_plus_dlc_minutes")
    private Integer avgMainPlusDlcMinutes;
    @ManyToMany(mappedBy = "games")
    private List<User> userList;

    public Game() {

    }

    public Integer getIgdbId() {
        return igdbId;
    }

    public void setIgdbId(Integer igdbId) {
        this.igdbId = igdbId;
    }

    public Game(String gameName) {
        this.gameName = gameName;
    }

    public Integer getGameId() {
        return gameId;
    }

    public void setGameId(Integer gameId) {
        this.gameId = gameId;
    }

    public String getGameName() {
        return gameName;
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

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }
    @JsonIgnore
    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    @Override
    public String toString() {
        return "Game{" +
                "gameId=" + gameId +
                ", gameName='" + gameName + '\'' +
                ", avgMainStoryHours=" + avgMainStoryHours +
                ", avgMainStoryMinutes=" + avgMainStoryMinutes +
                ", avgCompletionistHours=" + avgCompletionistHours +
                ", avgCompletionistMinutes=" + avgCompletionistMinutes +
                ", avgMainPlusDlcHours=" + avgMainPlusDlcHours +
                ", avgMainPlusDlcMinutes=" + avgMainPlusDlcMinutes +
                ", userList=" + userList +
                '}';
    }
}
