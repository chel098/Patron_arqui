package com.botcine.bot_cine.api;

import com.botcine.bot_cine.bl.PeliculasBl;
import com.botcine.bot_cine.bl.ProductoBl;
import com.botcine.bot_cine.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT})
public class ProductoApi {
    private ProductoBl productoBl;

    @Autowired
    public ProductoApi(ProductoBl productoBl){
        this.productoBl=productoBl;
    }

    @GetMapping(path = "/producto", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ProductoDto> findLast10PermissionsByChatId() {
        return productoBl.findLast10PermissionsByChatId();
    }


    @GetMapping(path = "/compraProducto/{compraProductoId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ProductoDto findByCompra(@PathVariable("compraProductoId") String nombre, String image, String precio, String sabor){
        return productoBl.compraProd(nombre, image, precio,  sabor);
    }

    @PostMapping(path="/compraProducto", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE )
    public String saveCompra(@RequestBody CompraProductoDto compraProductoDto) {
        productoBl.saveCompra(compraProductoDto.getFecha(),compraProductoDto.getCantidad(),compraProductoDto.getPrecio_final(),compraProductoDto.getProducto_productoId());
        return "Producto Registrado";
    }

    @GetMapping(path = "/datosPagoProducto/{datosPagoId}:", produces = MediaType.APPLICATION_JSON_VALUE)
    public ProductoDto PagoProd(@PathVariable("datosPagoId") String nombre, String image, Integer cantidad, Double precio){
        return productoBl.PagoProd(nombre, image, cantidad, precio);
    }

    @PostMapping(path="/datosPagoP:", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE )
    public String savePago(@RequestBody DatosPagosProductoDto datosPagosProductoDto) {
        productoBl.savePago(datosPagosProductoDto.getPayment(),datosPagosProductoDto.getCard(),datosPagosProductoDto.getLastDigist(),datosPagosProductoDto.getExpirationDate(),datosPagosProductoDto.getName(),datosPagosProductoDto.getNit(),datosPagosProductoDto.getCompra_producto_compraProductoId());
        return "Producto Registrado";
    }

}
