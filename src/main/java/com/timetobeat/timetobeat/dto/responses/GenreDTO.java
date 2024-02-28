package com.timetobeat.timetobeat.dto.responses;

public class GenreDTO {
    private Integer id;
    private String name;

    public GenreDTO() {
    }

    public GenreDTO(Integer id, String name) {
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
