package com.botcine.bot_cine.dto;

public class ReservaCDto {
    Integer ccp;
    Integer paquetes_cpr;
    Integer cantidad;
    Double precio_final;

    public ReservaCDto(Integer ccp, Integer paquetes_cpr, Integer cantidad, Double precio_final) {
        this.ccp = ccp;
        this.paquetes_cpr = paquetes_cpr;
        this.cantidad = cantidad;
        this.precio_final = precio_final;
    }

    public Integer getCcp() {
        return ccp;
    }

    public void setCcp(Integer ccp) {
        this.ccp = ccp;
    }

    public Integer getPaquetes_cpr() {
        return paquetes_cpr;
    }

    public void setPaquetes_cpr(Integer paquetes_cpr) {
        this.paquetes_cpr = paquetes_cpr;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPrecio_final() {
        return precio_final;
    }

    public void setPrecio_final(Double precio_final) {
        this.precio_final = precio_final;
    }

    @Override
    public String toString() {
        return "ReservaC{" +
                "ccp=" + ccp +
                ", paquetes_cpr=" + paquetes_cpr +
                ", cantidad=" + cantidad +
                ", precio_final=" + precio_final +
                '}';
    }
}
