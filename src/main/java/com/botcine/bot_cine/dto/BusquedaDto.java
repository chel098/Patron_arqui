package com.botcine.bot_cine.dto;

public class BusquedaDto {
    private Integer peliculasId;
    private String name;

    public BusquedaDto(Integer peliculasId, String name) {
        this.peliculasId = peliculasId;
        this.name = name;
    }

    public Integer getPeliculasId() {
        return peliculasId;
    }

    public void setPeliculasId(Integer peliculasId) {
        this.peliculasId = peliculasId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "BusquedaDto{" +
                "peliculasId=" + peliculasId +
                ", name='" + name + '\'' +
                '}';
    }
}
