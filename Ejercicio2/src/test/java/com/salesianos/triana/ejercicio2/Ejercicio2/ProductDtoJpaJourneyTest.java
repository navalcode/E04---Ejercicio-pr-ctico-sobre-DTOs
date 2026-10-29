package com.salesianos.triana.ejercicio2.Ejercicio2;

import com.salesianos.triana.ejercicio2.Ejercicio2.dto.*;
import com.salesianos.triana.ejercicio2.Ejercicio2.model.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import javax.persistence.EntityManager;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest(properties="spring.datasource.url=jdbc:h2:mem:dto_review;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE")
class ProductDtoJpaJourneyTest {
    @Autowired EntityManager em;
    @Test void createdCategoryCascadesItsProductsAndKeepsImageData(){
        Producto product=new Producto("Sample","Fictional",2.5,null,new ArrayList<>(List.of("https://images.example.invalid/sample.png")));
        Categoria category=new CategoriaDtoConverter().createCategoriaDtoToCategoria(new CreateCategoriaDto("Sample",new ArrayList<>(List.of(product))));
        em.persist(category);em.flush();Long categoryId=category.getId();long productId=product.getId();em.clear();
        Producto loaded=em.find(Producto.class,productId);GetProductoDto dto=new ProductoDtoConverter().productoToGetProductoDto(loaded);dto.getImagenes().clear();em.flush();em.clear();
        assertEquals(categoryId,em.find(Producto.class,productId).getCategoria().getId());assertEquals(1,em.find(Producto.class,productId).getImagenes().size());assertEquals(1,em.find(Categoria.class,categoryId).getProductos().size());
    }
    @Test void transferReloadsBothOwnersAndOrphanRemovalDeletesOnlyTheProduct(){
        Categoria first=new Categoria(),second=new Categoria();first.setNombre("First");second.setNombre("Second");Producto product=new Producto("Sample","Fictional",2.5,null,new ArrayList<>());first.addProducto(product);em.persist(first);em.persist(second);em.flush();
        Long firstId=first.getId(),secondId=second.getId();long id=product.getId();second.addProducto(product);em.flush();em.clear();
        assertTrue(em.find(Categoria.class,firstId).getProductos().isEmpty());assertEquals(1,em.find(Categoria.class,secondId).getProductos().size());assertEquals(secondId,em.find(Producto.class,id).getCategoria().getId());
        second=em.find(Categoria.class,secondId);second.removeProducto(em.find(Producto.class,id));em.flush();em.clear();assertNull(em.find(Producto.class,id));assertNotNull(em.find(Categoria.class,firstId));assertNotNull(em.find(Categoria.class,secondId));
    }
}
