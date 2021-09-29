package com.salesianos.triana.ejercicio2.Ejercicio2;

import com.salesianos.triana.ejercicio2.Ejercicio2.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
}
