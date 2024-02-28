package com.timetobeat.timetobeat.dto.responses;

import java.util.List;

public class GameFullDTO {
    private Integer id;
    private CoverDTO cover;
    private List<GenreDTO> genres;
    private String name;
    private List<PlatformDTO> platforms;
    private String summary;

    public GameFullDTO() {
    }
    public GameFullDTO(Integer id, CoverDTO cover, List<GenreDTO> genres, String name, List<PlatformDTO> platforms, String summary) {
        this.id = id;
        this.cover = cover;
        this.genres = genres;
        this.name = name;
        this.platforms = platforms;
        this.summary = summary;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
