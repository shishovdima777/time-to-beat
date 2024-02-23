package com.timetobeat.timetobeat.dto;

public class CoverDTO {
    private int id;
    private String url;

    public CoverDTO() {
    }

    public CoverDTO(int id, String url) {
        this.id = id;
        this.url = url;
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
}
