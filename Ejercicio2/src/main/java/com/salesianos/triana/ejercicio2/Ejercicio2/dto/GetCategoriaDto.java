package com.salesianos.triana.ejercicio2.Ejercicio2.dto;

import com.salesianos.triana.ejercicio2.Ejercicio2.model.Producto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetCategoriaDto {

    private String nombre;
    private List<Producto> productos;
}
