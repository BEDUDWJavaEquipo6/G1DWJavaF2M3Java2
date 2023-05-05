package org.bedu.postwork.javase2project.multithreading;

import org.bedu.postwork.javase2project.model.Curso;
import org.bedu.postwork.javase2project.model.Estudiante;
import org.bedu.postwork.javase2project.model.Materia;
import org.bedu.postwork.javase2project.service.CreadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Controller
public class Postwork2 {
    private final CreadorService creadorService;
    @Autowired
    public Postwork2(CreadorService creadorService){
        this.creadorService = creadorService;
    }

    public Curso CrearCurso(Curso curso, String nombreMateria, String nombreAlumno, char ciclo){
        return creadorService.guardaCurso(curso);
    }

    public Materia CrearMateria(String nombre){
        Materia materia = new Materia();
        materia.setNombre(nombre);
        return materia;
    }

    public Estudiante CrearEstudiante(String nombre){
        Estudiante estudiante = new Estudiante();
        estudiante.setNombreCompleto(nombre);
        return estudiante;
    }

    public Map<Estudiante, Integer> generadorCalificaciones(String nombreAlumno){
        Random random = new Random();
        Map<Estudiante, Integer> calificacion = new HashMap<>();
        for (int i=0; i<5; i++){
            calificacion.put(creadorService.guardaEstudiante(CrearEstudiante(nombreAlumno + i)),
                    random.nextInt(10) + 1);
        }
        return calificacion;
    }
}
