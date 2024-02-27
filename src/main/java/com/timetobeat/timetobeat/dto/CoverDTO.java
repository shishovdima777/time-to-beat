package com.timetobeat.timetobeat.dto;

public class CoverDTO {
    private Integer id;
    private String url;

    public CoverDTO() {
    }

    public CoverDTO(Integer id, String url) {
        this.id = id;
        this.url = url;
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
}
