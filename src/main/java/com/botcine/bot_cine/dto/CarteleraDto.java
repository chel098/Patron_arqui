package com.botcine.bot_cine.dto;

public class CarteleraDto {
    private Integer cpt;
    private Integer cantidad;
    private String nombre_pelicula;
    private String horario;
    private String asientos;

    public CarteleraDto(Integer cpt, Integer cantidad, String nombre_pelicula, String horario, String asientos) {
        this.cpt = cpt;
        this.cantidad = cantidad;
        this.nombre_pelicula = nombre_pelicula;
        this.horario = horario;
        this.asientos = asientos;
    }

    public Integer getCpt() {
        return cpt;
    }

    public void setCpt(Integer cpt) {
        this.cpt = cpt;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public String getNombre_pelicula() {
        return nombre_pelicula;
    }

    public void setNombre_pelicula(String nombre_pelicula) {
        this.nombre_pelicula = nombre_pelicula;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getAsientos() {
        return asientos;
    }

    public void setAsientos(String asientos) {
        this.asientos = asientos;
    }

    @Override
    public String toString() {
        return "CarteleraDto{" +
                "cpt=" + cpt +
                ", cantidad=" + cantidad +
                ", nombre_pelicula='" + nombre_pelicula + '\'' +
                ", horario='" + horario + '\'' +
                ", asientos='" + asientos + '\'' +
                '}';
    }
}
