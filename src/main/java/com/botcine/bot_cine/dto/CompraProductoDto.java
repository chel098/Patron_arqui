package com.botcine.bot_cine.dto;

public class CompraProductoDto {
    String fecha;
    Integer cantidad;
    Double precio_final;
    Integer Producto_productoId;

    public CompraProductoDto(String fecha, Integer cantidad, Double precio_final, Integer producto_productoId) {
        this.fecha = fecha;
        this.cantidad = cantidad;
        this.precio_final = precio_final;
        Producto_productoId = producto_productoId;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
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

    public Integer getProducto_productoId() {
        return Producto_productoId;
    }

    public void setProducto_productoId(Integer producto_productoId) {
        Producto_productoId = producto_productoId;
    }

    @Override
    public String toString() {
        return "CompraProductoDto{" +
                "fecha='" + fecha + '\'' +
                ", cantidad=" + cantidad +
                ", precio_final=" + precio_final +
                ", Producto_productoId=" + Producto_productoId +
                '}';
    }
}
