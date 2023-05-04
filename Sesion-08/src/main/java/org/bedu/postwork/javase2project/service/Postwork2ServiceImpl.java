package org.bedu.postwork.javase2project.service;

import org.bedu.postwork.javase2project.model.Curso;
import org.bedu.postwork.javase2project.model.Estudiante;
import org.bedu.postwork.javase2project.model.Materia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Service
public class Postwork2ServiceImpl implements Postwork2Service {

    private final CreadorService creadorService;

    @Autowired
    public Postwork2ServiceImpl(CreadorService creadorService) {
        this.creadorService = creadorService;
    }

    @Override
    public Curso CrearCurso(Curso curso, String nombreMateria,
                            Map<String, Integer> estudianteConCalificacion, String ciclo) {
        curso.setCiclo(ciclo);
        curso.setMaterias(creadorService.guardaMateria(CrearMateria(nombreMateria)));
        curso.setCalificaciones(generadorCalificaciones(estudianteConCalificacion));
        return creadorService.guardaCurso(curso);
    }

    @Override
    public Materia CrearMateria(String nombre) {
        Materia materia = new Materia();
        materia.setNombre(nombre);
        return materia;
    }

    @Override
    public Estudiante CrearEstudiante(String nombre) {
        Estudiante estudiante = new Estudiante();
        estudiante.setNombreCompleto(nombre);
        return estudiante;
    }

    @Override
    public Map<Estudiante, Integer> generadorCalificaciones(Map<String, Integer> estudianteConCalificacion) {
        Map<Estudiante, Integer> calificacion = new HashMap<>();
        estudianteConCalificacion.entrySet().stream()
                .forEach(e ->
                        calificacion.put(
                                creadorService.guardaEstudiante(CrearEstudiante(e.getKey())),e.getValue())
                );
        return calificacion;
    }
}
