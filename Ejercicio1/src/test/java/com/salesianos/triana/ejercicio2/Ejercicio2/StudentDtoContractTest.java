package com.salesianos.triana.ejercicio2.Ejercicio2;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.salesianos.triana.ejercicio2.Ejercicio2.dto.*;
import com.salesianos.triana.ejercicio2.Ejercicio2.model.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class StudentDtoContractTest {
    final AlumnoDtoConverter converter=new AlumnoDtoConverter();
    @Test void creationMapsBothSurnamesAndReferencesWithoutInventingIds() {
        Direccion address=new Direccion("Street","Fictional 1",null,"00001","Sample","Sample");
        Curso course=new Curso("Mobile","Sample","Fictional tutor","A");
        Alumno student=converter.createAlumnoDtoToAlumno(new CreateAlumnoDto("Ada","Sample","Second","000000001","student@example.invalid",address,course));
        assertNull(student.getId());assertEquals("Ada",student.getNombre());assertEquals("Sample",student.getApellido());assertEquals("Second",student.getApellido2());
        assertEquals("000000001",student.getTelefono());assertEquals("student@example.invalid",student.getEmail());assertSame(address,student.getDireccion());assertSame(course,student.getCurso());
    }
    @Test void readMapsAllFieldsAndKeepsNullableValues() {
        Alumno student=new Alumno("Ada","Sample",null,null,"student@example.invalid",null,null);GetAlumnoDto dto=converter.alumnoToGetAlumnoDto(student);
        assertEquals("Ada",dto.getNombre());assertEquals("Sample",dto.getApellido1());assertNull(dto.getApellido2());assertNull(dto.getTelefono());assertEquals("student@example.invalid",dto.getEmail());assertNull(dto.getDireccion());assertNull(dto.getCursoId());
    }
    @Test void existingCursoIdPropertyIsAnObjectNotAnIdentifier() throws Exception {
        Curso course=new Curso("Sample course","Sample","Sample","A");course.setId(42L);
        GetAlumnoDto dto=converter.alumnoToGetAlumnoDto(new Alumno("Ada","Sample",null,null,null,null,course));
        var tree=new ObjectMapper().readTree(new ObjectMapper().writeValueAsString(dto));assertTrue(tree.get("cursoId").isObject());assertEquals(42L,tree.get("cursoId").get("id").asLong());assertFalse(tree.has("id"));
    }
}
