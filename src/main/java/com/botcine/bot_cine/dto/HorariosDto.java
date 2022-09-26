package com.botcine.bot_cine.dto;

public class HorariosDto {
    private Integer peliculasId;
    private Integer horarioId;
    private String name;
    private String image;
    private String schedule;

    public HorariosDto(Integer peliculasId,Integer horarioId, String name, String image, String schedule) {
        this.peliculasId = peliculasId;
        this.horarioId = horarioId;
        this.name = name;
        this.image = image;
        this.schedule = schedule;
    }

    public Integer getPeliculasId() {
        return peliculasId;
    }

    public void setPeliculasId(Integer peliculasId) {
        this.peliculasId = peliculasId;
    }

    public Integer getHorarioId() {
        return horarioId;
    }

    public void setHorarioId(Integer horarioId) {
        this.horarioId = horarioId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    @Override
    public String toString() {
        return "HorariosDto{" +
                "peliculasId=" + peliculasId +
                ", name='" + name + '\'' +
                ", image='" + image + '\'' +
                ", schedule='" + schedule + '\'' +
                '}';
    }
}
