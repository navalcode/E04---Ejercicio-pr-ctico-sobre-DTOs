package com.salesianos.triana.ejercicio2.Ejercicio2.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Alumno {

    @Id
    @GeneratedValue
    private Long id;
    private String nombre;
    private String apellido;
    private String apellido2;

    @Column(length = 9)
    private String telefono;
    private String email;

    @ManyToOne
    private Direccion direccion;

    @ManyToOne
    private Curso curso;

    public Alumno(String nombre, String apellido, String apellido2, String telefono, String email, Direccion direccion, Curso curso) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.apellido2 = apellido2;
        this.telefono = telefono;
        this.email = email;
        this.direccion = direccion;
        this.curso = curso;
    }
}
