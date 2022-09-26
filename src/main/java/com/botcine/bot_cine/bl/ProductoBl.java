package com.botcine.bot_cine.bl;

import com.botcine.bot_cine.dao.PeliculasDao;
import com.botcine.bot_cine.dao.ProductoDao;
import com.botcine.bot_cine.dto.PeliculasDto;
import com.botcine.bot_cine.dto.ProductoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoBl {
    private ProductoDao productoDao;

    @Autowired
    public ProductoBl(ProductoDao productoDao){
        this.productoDao = productoDao;
    }


    public List<ProductoDto> findLast10PermissionsByChatId() {
        List<ProductoDto> Prod = productoDao.findAllProductos();
        return Prod;
    }

    public ProductoDto compraProd(String nombre, String image, String precio, String sabor){
        return productoDao.compraProductoG(nombre, image, precio,  sabor);
    }

    public void saveCompra(String fecha,Integer cantidad,Double precio_final,Integer Producto_productoId){
        productoDao.compraProductoP(fecha, cantidad, precio_final, Producto_productoId);
    }

    public ProductoDto PagoProd(String nombre, String image, Integer cantidad, Double precio){
        return productoDao.datosPagoG(nombre, image, cantidad, precio);
    }

    public void savePago(String payment, Integer card, Integer lastDigist, String expirationDate, String name, Integer nit, Integer compra_producto_compraProductoId){
        productoDao.datosPagoP(payment,  card,  lastDigist,  expirationDate,  name,  nit,  compra_producto_compraProductoId);
    }
}
