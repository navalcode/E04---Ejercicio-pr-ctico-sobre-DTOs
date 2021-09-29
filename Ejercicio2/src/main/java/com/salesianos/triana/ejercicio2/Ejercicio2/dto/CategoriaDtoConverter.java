package com.salesianos.triana.ejercicio2.Ejercicio2.dto;

import com.salesianos.triana.ejercicio2.Ejercicio2.model.Categoria;
import org.springframework.stereotype.Component;

@Component
public class CategoriaDtoConverter {

    public Categoria createCategoriaDtoToCategoria(CreateCategoriaDto c) {
        return new Categoria(
                c.getNombre(),
                c.getProductos()
        );
    }

    public GetCategoriaDto categoriaToGetCategoriaoDto(Categoria c) {
        GetCategoriaDto result = new GetCategoriaDto();
        result.setNombre(c.getNombre());
        result.setProductos(c.getProductos());
        return result;
    }
}
