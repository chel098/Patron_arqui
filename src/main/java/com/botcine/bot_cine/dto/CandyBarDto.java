package com.botcine.bot_cine.dto;

public class CandyBarDto {
    Integer cpr;
    String nombre;
    Double precio;

    public CandyBarDto(Integer cpr, String nombre, Double precio) {
        this.cpr = cpr;
        this.nombre = nombre;
        this.precio = precio;
    }

    public Integer getCpr() {
        return cpr;
    }

    public void setCpr(Integer cpr) {
        this.cpr = cpr;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return cpr + ". " + nombre + '\t' +
                precio + " Bs";
    }
}
