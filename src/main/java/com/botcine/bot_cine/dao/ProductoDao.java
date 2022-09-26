package com.botcine.bot_cine.dao;


import com.botcine.bot_cine.dto.ProductoDto;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductoDao {

    @Select("SELECT nombre, sabor,image, precio"+ " FROM Producto")
    public List<ProductoDto> findAllProductos();

    @Select("SELECT nombre, image, precio, sabor "+ "FROM Producto")
    ProductoDto compraProductoG(String nombre, String image, String precio, String sabor);


    @Insert("INSERT INTO Compra_producto(fecha, cantidad, precio_final, Producto_productoId)" +
            " VALUES (#{fecha}, #{cantidad}, #{precio_final}, #{Producto_productoId})")
    void compraProductoP(@Param("fecha") String fecha, @Param("cantidad") Integer cantidad, @Param("precio_final") Double precio_final, @Param("Producto_productoId") Integer Producto_productoId);

    @Select("SELECT a.peliculasId, a.name, a.image, a.city, a.cinema, b.schedule" +
            "FROM peliculas a, horarios b WHERE a.peliculas = b.peliculas ")
    ProductoDto datosPagoG(String nombre, String image, Integer cantidad, Double precio);

    @Insert("INSERT INTO Datos_pago_producto(payment, card, lastDigist, expirationDate, name, nit, Compra_producto_compraProductoId)" +
            " VALUES (#{payment}, #{card}, #{lastDigist}, #{expirationDate}, #{name}, #{nit}, #{Compra_producto_compraProductoId})")
    void datosPagoP(@Param("payment") String payment, @Param("card") Integer card, @Param("lastDigist") Integer lastDigit, @Param("expirationDate") String expirationDate, @Param("name") String name, @Param("nit") Integer nit, @Param("Compra_producto_compraProductoId") Integer Compra_producto_compraProductoId);



}
