package com.salesianos.triana.ejercicio2.Ejercicio2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Producto {

    @Id
    @GeneratedValue
    private long id;

    private String nombre;
    private String desc;
    private double pvp;

    @ManyToOne
    private Categoria categoria;

    //Necesitamos una anotación especial para que se pueda generar una nueva tabla
    //para las imagenes, de esta forma respetamos el sistema relacional.
    @ElementCollection
    private List<String> imagenes;

    public Producto(String nombre, String desc, double pvp, Categoria categoria, List<String> imagenes) {
        this.nombre = nombre;
        this.desc = desc;
        this.pvp = pvp;
        this.categoria = categoria;
        this.imagenes = imagenes;
    }
}
