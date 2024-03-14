package com.timetobeat.timetobeat.dto.responses;

public class CoverDTO {
    private String url;

    public CoverDTO() {
    }

    public CoverDTO(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
