package com.salesianos.triana.ejercicio2.Ejercicio2.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Categoria {

    @Id
    @GeneratedValue
    private Long id;

    private String nombre;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Producto> productos = new ArrayList<>();

    public Categoria(String nombre, List<Producto> productos) {
        this.nombre = nombre;
        if (productos != null) {
            productos.forEach(java.util.Objects::requireNonNull);
            productos.forEach(this::addProducto);
        }
    }

    public void addProducto(Producto product) {
        java.util.Objects.requireNonNull(product, "product");
        Categoria previous = product.getCategoria();
        if (previous != null && previous != this) {
            previous.getProductos().removeIf(item -> item == product);
        }
        product.setCategoria(this);
        if (productos.stream().noneMatch(item -> item == product)) productos.add(product);
    }

    public void removeProducto(Producto product) {
        java.util.Objects.requireNonNull(product, "product");
        productos.removeIf(item -> item == product);
        if (product.getCategoria() == this) product.setCategoria(null);
    }
}
