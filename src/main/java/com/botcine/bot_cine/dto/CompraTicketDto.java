package com.botcine.bot_cine.dto;

public class CompraTicketDto {
    private String seats;
    private String date;
    private Integer peliculas_horario_id_peliculas_horario;

    public CompraTicketDto(String seats, String date, Integer peliculas_horarios_id_peliculas_horario) {
        this.seats = seats;
        this.date = date;
        this.peliculas_horario_id_peliculas_horario = peliculas_horarios_id_peliculas_horario;
    }

    public String getSeats() {
        return seats;
    }

    public void setSeats(String seats) {
        this.seats = seats;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getPeliculas_horario_id_peliculas_horario() {
        return peliculas_horario_id_peliculas_horario;
    }

    public void setPeliculas_horarios_id_peliculas_horario(Integer peliculas_horarios_id_peliculas_horario) {
        this.peliculas_horario_id_peliculas_horario = peliculas_horarios_id_peliculas_horario;
    }

    @Override
    public String toString() {
        return "CompraTicketDto{" +
                "seats='" + seats + '\'' +
                ", date='" + date + '\'' +
                ", peliculas_horarios_id_peliculas_horario=" + peliculas_horario_id_peliculas_horario +
                '}';
    }
}
