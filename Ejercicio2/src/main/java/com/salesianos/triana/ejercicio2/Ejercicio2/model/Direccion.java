package com.salesianos.triana.ejercicio2.Ejercicio2.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class Direccion {

    @Id
    @GeneratedValue
    private Long id;
    private String tipoVia;
    private String linea1;
    private String linea2;

    //No usaremos el código postal para operar, podemos dejarlo en String
    private String cp;
    private String poblacion;
    private String provincia;

    public Direccion(String tipoVia, String linea1, String linea2, String cp, String poblacion, String provincia) {
        this.tipoVia = tipoVia;
        this.linea1 = linea1;
        this.linea2 = linea2;
        this.cp = cp;
        this.poblacion = poblacion;
        this.provincia = provincia;
    }
}
