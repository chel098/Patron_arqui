package com.botcine.bot_cine.dto;

public class AsientosDto {
    private Integer peliculasId;
    private Integer horarioId;
    private String seats;

    public AsientosDto(Integer peliculasId, Integer horarioId, String seats) {
        this.peliculasId = peliculasId;
        this.horarioId = horarioId;
        this.seats = seats;
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

    public String getSeats() {
        return seats;
    }

    public void setSeats(String seats) {
        this.seats = seats;
    }

    @Override
    public String toString() {
        return "AsientosDto{" +
                "peliculasId=" + peliculasId +
                ", horarioId=" + horarioId +
                ", seats='" + seats + '\'' +
                '}';
    }
}
