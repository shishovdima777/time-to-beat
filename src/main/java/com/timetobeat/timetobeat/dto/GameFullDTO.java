package com.timetobeat.timetobeat.dto;

import java.util.List;

public class GameFullDTO {
    private int id;
    private CoverDTO cover;
    private List<GenreDTO> genres;
    private String name;
    private List<PlatformDTO> platforms;
    private String summary;

    public GameFullDTO() {
    }

    public GameFullDTO(int id, CoverDTO cover, List<GenreDTO> genres, String name, List<PlatformDTO> platforms, String summary) {
        this.id = id;
        this.cover = cover;
        this.genres = genres;
        this.name = name;
        this.platforms = platforms;
        this.summary = summary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CoverDTO getCover() {
        return cover;
    }

    public void setCover(CoverDTO cover) {
        this.cover = cover;
    }

    public List<GenreDTO> getGenres() {
        return genres;
    }

    public void setGenres(List<GenreDTO> genres) {
        this.genres = genres;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<PlatformDTO> getPlatforms() {
        return platforms;
    }

    public void setPlatforms(List<PlatformDTO> platforms) {
        this.platforms = platforms;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
}
