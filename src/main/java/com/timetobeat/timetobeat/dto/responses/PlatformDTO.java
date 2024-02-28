package com.timetobeat.timetobeat.dto.responses;

public class PlatformDTO {
    private Integer id;
    private String name;

    public PlatformDTO() {
    }

    public PlatformDTO(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
