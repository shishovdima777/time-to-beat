package com.timetobeat.timetobeat.dto.responses;

public class PlatformDTO {
    private String name;

    public PlatformDTO() {
    }

    public PlatformDTO(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
