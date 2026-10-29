# Java DTO exercises: conversion and ownership

[Español](README.es.md) · [GitHub](https://github.com/navalcode)

## Overview

Two independent coursework modules reviewed with **15 local tests**: four in Ejercicio1 and eleven in Ejercicio2. Each keeps its original application context test. Both use the same historical Java package/artifact name, but are built separately.

Ejercicio1 maps students, both surnames, phone/email, address and course in both directions. Its legacy `cursoId` property contains a Curso object, not a numeric ID; the JSON contract test makes that limitation explicit. No REST controller or fully detached DTO boundary is claimed.

Ejercicio2 copies mutable product/image collections during conversion. Creating a category attaches its products on both sides; creating a product attaches it to its category. Repeated attachment does not duplicate a reference, transfers detach the previous owner and removal from the wrong category preserves the real owner. Two equal-valued transient products remain distinct: graph helpers use object identity rather than Lombok value equality.

JPA journeys persist/cascade, flush/clear/reload, transfer a product and remove an orphan without deleting categories. Editing a converted image list does not change the managed entity or its persisted images. Copies are shallow: category/product/course/address objects remain references, prices remain double, and no input-validation API is invented.

Start with [student contracts](Ejercicio1/src/test/java/com/salesianos/triana/ejercicio2/Ejercicio2/StudentDtoContractTest.java), [product contracts](Ejercicio2/src/test/java/com/salesianos/triana/ejercicio2/Ejercicio2/ProductDtoContractTest.java) and [persistence journeys](Ejercicio2/src/test/java/com/salesianos/triana/ejercicio2/Ejercicio2/ProductDtoJpaJourneyTest.java). Converter/helper method names and mappings are retained. The review preserves historical Maven/Spring pins and adds no hosted CI or new blanket license.

## Run

Requires JDK 17. From the repository root:

```sh
cd Ejercicio1
sh ./mvnw verify
cd ../Ejercicio2
sh ./mvnw verify
```

Local JDK 17/macOS results from 29 October 2026 are recorded in [verification.json](docs/verification.json). They do not establish production readiness. [Design and contract decisions](DESIGN.md) · [Components and attribution](THIRD_PARTY.md).

## Resumen

[La versión española completa](README.es.md) cubre los mismos contratos, comandos y límites.
