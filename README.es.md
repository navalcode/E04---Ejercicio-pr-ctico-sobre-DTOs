# Java DTO exercises: conversion and ownership

[English](README.md) · [GitHub](https://github.com/navalcode)

## Resumen

Dos módulos formativos independientes revisados con **15 pruebas locales**: cuatro en Ejercicio1 y once en Ejercicio2. Cada uno conserva su test original de contexto. Comparten el nombre histórico de paquete/artefacto Java, pero se compilan por separado.

Ejercicio1 convierte alumnos, ambos apellidos, teléfono/email, dirección y curso en las dos direcciones. Su propiedad original `cursoId` contiene un objeto Curso, no un ID numérico; un test JSON deja explícito ese límite. No se presenta como controlador REST ni como frontera DTO completamente independiente de entidades.

Ejercicio2 copia las colecciones mutables de productos/imágenes durante la conversión. Crear una categoría vincula sus productos por ambos lados; crear un producto lo incorpora a su categoría. Repetir una asociación no duplica la referencia, transferir retira al propietario anterior y retirar desde otra categoría conserva al real. Dos productos transitorios con valores iguales siguen siendo distintos: los helpers usan identidad de objeto, sin confundirlos por la igualdad generada por Lombok.

Los recorridos JPA persisten en cascada, hacen flush/clear/reload, transfieren un producto y eliminan un huérfano sin borrar categorías. Modificar la lista de imágenes convertida no cambia la entidad gestionada ni las imágenes guardadas. Las copias son superficiales: categoría/producto/curso/dirección siguen siendo referencias; los precios son double y no se inventa una API de validación.

Empieza por [contratos de alumnos](Ejercicio1/src/test/java/com/salesianos/triana/ejercicio2/Ejercicio2/StudentDtoContractTest.java), [contratos de productos](Ejercicio2/src/test/java/com/salesianos/triana/ejercicio2/Ejercicio2/ProductDtoContractTest.java) y [recorridos de persistencia](Ejercicio2/src/test/java/com/salesianos/triana/ejercicio2/Ejercicio2/ProductDtoJpaJourneyTest.java). Se mantienen los nombres de conversores/helpers y mappings. Se conservan las versiones históricas Maven/Spring; no se añade CI alojada ni una licencia general nueva.

## Ejecutar

Requiere JDK 17. Desde la raíz del repositorio:

```sh
cd Ejercicio1
sh ./mvnw verify
cd ../Ejercicio2
sh ./mvnw verify
```

Resultados locales con JDK 17/macOS del 29 de octubre de 2026 en [verification.json](docs/verification.json). No equivalen a un servicio de producción. [Decisiones de diseño y contrato](DESIGN.md) · [Componentes y atribución](THIRD_PARTY.md).
