package com.salesianos.triana.ejercicio2.Ejercicio2.dto;

import com.salesianos.triana.ejercicio2.Ejercicio2.model.Producto;
import lombok.*;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCategoriaDto {

    private String nombre;
    private List<Producto> productos;
}
