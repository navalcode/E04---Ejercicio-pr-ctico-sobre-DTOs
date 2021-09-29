package com.salesianos.triana.ejercicio2.Ejercicio2.dto;

import com.salesianos.triana.ejercicio2.Ejercicio2.model.Categoria;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetProductoDto {

    private String nombre;
    private double pvp;
    private String desc;
    private Categoria categoria;
    private List<String> imagenes;
}
