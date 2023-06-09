package org.bedu.postwork.javase2project.service;

import org.bedu.postwork.javase2project.model.Curso;
import org.bedu.postwork.javase2project.model.Estudiante;
import org.bedu.postwork.javase2project.model.Materia;

import java.util.List;
import java.util.Map;

public interface Postwork2Service {
    Curso CrearCurso(Curso curso, String nombreMateria, Map<String, Integer> estudianteConCalificacion, String ciclo);

    Materia CrearMateria(String nombre);

    Estudiante CrearEstudiante(String nombre);

    Map<Estudiante, Integer> generadorCalificaciones(Map<String, Integer> estudianteConCalificacion);

}
