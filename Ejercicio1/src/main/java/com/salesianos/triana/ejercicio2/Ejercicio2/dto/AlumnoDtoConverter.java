package com.salesianos.triana.ejercicio2.Ejercicio2.dto;

import com.salesianos.triana.ejercicio2.Ejercicio2.model.Alumno;
import org.springframework.stereotype.Component;

@Component
public class AlumnoDtoConverter {
    public Alumno createAlumnoDtoToAlumno (CreateAlumnoDto a){
        return new Alumno (
                a.getNombre(),
                a.getApellido1(),
                a.getApellido2(),
                a.getTelefono(),
                a.getEmail(),
                a.getDireccion(),
                a.getCursoId()
        );
    }

    public GetAlumnoDto alumnoToGetAlumnoDto(Alumno a ){
        GetAlumnoDto result = new GetAlumnoDto();
        result.setNombre(a.getNombre());
        result.setApellido1(a.getApellido());
        result.setApellido2(a.getApellido2());
        result.setTelefono(a.getTelefono());
        result.setEmail(a.getEmail());
        result.setDireccion(a.getDireccion());
        result.setCursoId(a.getCurso());
        return result;
    }
}
