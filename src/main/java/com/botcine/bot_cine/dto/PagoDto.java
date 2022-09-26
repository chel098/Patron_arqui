package com.botcine.bot_cine.dto;

public class PagoDto {
    private Integer peliculasId;
    private Integer horarioId;
    private String name;
    private String image;
    private String tickets;
    private String seats;

    public PagoDto(Integer peliculasId, Integer horarioId, String name, String image, String tickets, String seats) {
        this.peliculasId = peliculasId;
        this.horarioId = horarioId;
        this.name = name;
        this.image = image;
        this.tickets = tickets;
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

    public String getTickets() {
        return tickets;
    }

    public void setTickets(String tickets) {
        this.tickets = tickets;
    }

    public String getSeats() {
        return seats;
    }

    public void setSeats(String seats) {
        this.seats = seats;
    }

    @Override
    public String toString() {
        return "PagoDto{" +
                "peliculasId=" + peliculasId +
                ", horarioId=" + horarioId +
                ", name='" + name + '\'' +
                ", image='" + image + '\'' +
                ", tickets='" + tickets + '\'' +
                ", seats='" + seats + '\'' +
                '}';
    }
}
