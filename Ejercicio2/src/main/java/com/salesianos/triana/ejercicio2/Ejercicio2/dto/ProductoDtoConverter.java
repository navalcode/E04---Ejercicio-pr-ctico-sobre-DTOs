package com.salesianos.triana.ejercicio2.Ejercicio2.dto;

import com.salesianos.triana.ejercicio2.Ejercicio2.model.Producto;
import org.springframework.stereotype.Component;

@Component
public class ProductoDtoConverter {

    public Producto createProductoDtoToProducto(CreateProductoDto c) {
        return new Producto(
                c.getNombre(),
                c.getDesc(),
                c.getPvp(),
                c.getCategoria(),
                c.getImagenes()
        );
    }

    public GetProductoDto productoToGetProductoDto(Producto p) {
        GetProductoDto result = new GetProductoDto();
        result.setNombre(p.getNombre());
        result.setDesc(p.getDesc());
        result.setCategoria(p.getCategoria());
        result.setPvp(p.getPvp());
        result.setImagenes(p.getImagenes());
        return result;
    }
}
