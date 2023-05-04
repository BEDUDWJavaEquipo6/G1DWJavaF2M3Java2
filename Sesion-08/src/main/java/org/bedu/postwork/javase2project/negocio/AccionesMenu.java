package org.bedu.postwork.javase2project.negocio;

import org.bedu.postwork.javase2project.model.Curso;
import org.bedu.postwork.javase2project.service.Postwork2ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.Map;

@Controller
public class AccionesMenu {


    private GeneradorNombresyCalificaciones generadorNombresyCalificaciones = new GeneradorNombresyCalificaciones();

    private final Postwork2ServiceImpl postwork2Service;

    @Autowired
    public AccionesMenu(Postwork2ServiceImpl postwork2Service){
        this.postwork2Service = postwork2Service;

    }

    private String ciclo;
    private String nombreMateria;
    private String nombreAlumno;
    private  int calificacion;
    private int numeroEstudiantes;
    private Map<String, Integer> estudianteConCalificacion = new HashMap<>();


    public void cargaManual(){
        Curso curso = new Curso();
        Lector  lector = new Lector();
        System.out.println("Ciclo:");
        ciclo = lector.leeDato();
        System.out.println("Nombre materia");
        nombreMateria = lector.leeDato();
        System.out.println("Número de estudiantes a ingresar: ");
        numeroEstudiantes = lector.leeNum();
        estudianteConCalificacion = generadorNombresyCalificaciones.manual(numeroEstudiantes);
        curso = postwork2Service.CrearCurso(curso,nombreMateria,estudianteConCalificacion,ciclo);
        if(!curso.getId().equals(null)){
            System.out.println("Curso guardado con éxito");
        }
    }

    public void cargaArchivo(){


    }
}
