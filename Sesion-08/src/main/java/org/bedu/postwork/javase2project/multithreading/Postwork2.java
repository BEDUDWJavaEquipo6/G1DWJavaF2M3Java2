package org.bedu.postwork.javase2project.multithreading;

import org.bedu.postwork.javase2project.model.Curso;
import org.bedu.postwork.javase2project.model.Estudiante;
import org.bedu.postwork.javase2project.model.Materia;
import org.bedu.postwork.javase2project.service.CursoService;
import org.bedu.postwork.javase2project.service.EstudianteService;
import org.bedu.postwork.javase2project.service.MateriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Controller
public class Postwork2 {
    private final EstudianteService estudianteService;
    private final CursoService cursoService;
    private final MateriaService materiaService;


    @Autowired
    public Postwork2(EstudianteService estudianteService, CursoService cursoService, MateriaService materiaService){
        this.estudianteService = estudianteService;
        this.cursoService = cursoService;
        this.materiaService = materiaService;
    }

    public Curso CrearCurso(Curso curso, String nombreMateria, String nombreAlumno, char ciclo){
        curso.setCiclo(ciclo);
        curso.setMaterias(materiaService.guardaMateria(CrearMateria(nombreMateria)));
        curso.setCalificaciones(generadorCalificaciones(nombreAlumno));
        return cursoService.guardaCurso(curso);
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
            calificacion.put(estudianteService.guardaEstudiante(CrearEstudiante(nombreAlumno + i)),
                    random.nextInt(10) + 1);
        }
        return calificacion;
    }
}
