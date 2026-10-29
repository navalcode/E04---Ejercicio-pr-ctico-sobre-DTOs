package com.salesianos.triana.ejercicio2.Ejercicio2;

import com.salesianos.triana.ejercicio2.Ejercicio2.dto.*;
import com.salesianos.triana.ejercicio2.Ejercicio2.model.*;
import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;
class ProductDtoContractTest {
    Producto product(){return new Producto("Sample","Fictional",2.5,null,new ArrayList<>(List.of("https://images.example.invalid/item.png")));}
    @Test void transferDetachesOldOwnerAndRepeatedAddDoesNotDuplicate() {
        Categoria first=new Categoria(),second=new Categoria();Producto p=product();first.addProducto(p);second.addProducto(p);second.addProducto(p);
        assertTrue(first.getProductos().isEmpty());assertEquals(1,second.getProductos().size());assertSame(second,p.getCategoria());
    }
    @Test void removalFromWrongOwnerDoesNotDetachProduct() {
        Categoria owner=new Categoria(),other=new Categoria();Producto p=product();owner.addProducto(p);other.removeProducto(p);assertSame(owner,p.getCategoria());assertEquals(1,owner.getProductos().size());
    }
    @Test void distinctEqualValuedTransientProductsRemainDistinct() {
        Categoria owner=new Categoria();Producto first=product(),second=product();owner.addProducto(first);owner.addProducto(second);owner.removeProducto(second);
        assertEquals(1,owner.getProductos().size());assertSame(first,owner.getProductos().get(0));assertSame(owner,first.getCategoria());assertNull(second.getCategoria());
    }
    @Test void nullAttachmentFailsBeforeMutation() {Categoria owner=new Categoria();assertThrows(NullPointerException.class,()->owner.addProducto(null));assertTrue(owner.getProductos().isEmpty());}
    @Test void createCategoryCopiesTheListAndSetsBothSides() {
        Producto p=product();List<Producto> source=new ArrayList<>(List.of(p));Categoria category=new CategoriaDtoConverter().createCategoriaDtoToCategoria(new CreateCategoriaDto("Sample",source));source.clear();
        assertEquals(1,category.getProductos().size());assertSame(category,p.getCategoria());
    }
    @Test void readCategoryCopiesTheCollectionButKeepsProductReferences() {
        Categoria category=new Categoria();Producto p=product();category.addProducto(p);GetCategoriaDto dto=new CategoriaDtoConverter().categoriaToGetCategoriaoDto(category);dto.getProductos().clear();assertEquals(1,category.getProductos().size());
    }
    @Test void createProductCopiesImageListAndAttachesToCategory() {
        List<String> images=new ArrayList<>(List.of("https://images.example.invalid/item.png"));Categoria category=new Categoria();Producto p=new ProductoDtoConverter().createProductoDtoToProducto(new CreateProductoDto("Sample","Fictional",2.5,category,images));images.clear();
        assertEquals("Sample",p.getNombre());assertEquals("Fictional",p.getDesc());assertEquals(2.5,p.getPvp());assertEquals(1,p.getImagenes().size());assertEquals(1,category.getProductos().size());assertSame(p,category.getProductos().get(0));
    }
    @Test void readProductCopiesImagesAndMapsEveryField() {
        Producto p=product();GetProductoDto dto=new ProductoDtoConverter().productoToGetProductoDto(p);dto.getImagenes().clear();assertEquals(1,p.getImagenes().size());assertEquals(p.getNombre(),dto.getNombre());assertEquals(p.getDesc(),dto.getDesc());assertEquals(p.getPvp(),dto.getPvp());assertSame(p.getCategoria(),dto.getCategoria());
    }
}
