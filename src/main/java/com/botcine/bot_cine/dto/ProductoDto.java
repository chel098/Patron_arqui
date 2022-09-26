package com.botcine.bot_cine.dto;

public class ProductoDto {
    private String nombre;
    private String sabor;
    private String image;
    private Double precio;


    public ProductoDto(String nombre, String sabor, String image, Double precio) {
        this.nombre = nombre;
        this.sabor = sabor;
        this.image = image;
        this.precio = precio;
    }





    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSabor() {
        return sabor;
    }

    public void setSabor(String sabor) {
        this.sabor = sabor;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }


    @Override
    public String toString() {
        return "ProductoDto{" +
                "nombre='" + nombre + '\'' +
                ", sabor='" + sabor + '\'' +
                ", image='" + image + '\'' +
                ", precio=" + precio;
    }
}
