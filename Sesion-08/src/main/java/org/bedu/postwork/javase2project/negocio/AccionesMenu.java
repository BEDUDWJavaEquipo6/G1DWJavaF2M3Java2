package org.bedu.postwork.javase2project.negocio;

import org.bedu.postwork.javase2project.model.Curso;
import org.bedu.postwork.javase2project.service.Postwork2ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@Controller
public class AccionesMenu {


    private GeneradorNombresyCalificaciones generadorNombresyCalificaciones = new GeneradorNombresyCalificaciones();
    private LeerArchivo leerArchivo = new LeerArchivo();
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
    private Map<String, Integer> estudianteConCalificacion = new LinkedHashMap<>();
    private Map<String, Integer> datosArchivo = new LinkedHashMap<>();
    private Curso curso = new Curso();
    private Lector  lector = new Lector();


    public void cargaManual(){
        System.out.println("Ciclo:");
        ciclo = lector.leeDato();
        System.out.println("Nombre materia");
        nombreMateria = lector.leeDato();
        System.out.println("Número de estudiantes a ingresar: ");
        numeroEstudiantes = lector.leeNum();
        estudianteConCalificacion = generadorNombresyCalificaciones.manual(numeroEstudiantes);
        guardaCurso(curso,nombreMateria,estudianteConCalificacion,ciclo);
    }

    public void cargaArchivo(){
        int primeraLinea =0;
        System.out.println("Ingresa la ruta del archivo");
        String ruta = lector.leeDato();
        datosArchivo = leerArchivo.datosArchivo(ruta);
        for (Map.Entry<String, Integer> datos : datosArchivo.entrySet()){
            if(primeraLinea<=0){
                nombreMateria = datos.getKey();
                ciclo = datos.getValue().toString();
            }else {
                estudianteConCalificacion.put(datos.getKey(), datos.getValue());
            }
            primeraLinea++;
        }
        guardaCurso(curso,nombreMateria,estudianteConCalificacion,ciclo);
    }

    public void guardaCurso(Curso curso, String nombreMateria, Map<String, Integer>estudianteConCalificacion, String ciclo){
        curso = postwork2Service.CrearCurso(curso,nombreMateria,estudianteConCalificacion,ciclo);
        if(!curso.getId().equals(null)){
            System.out.println("Curso guardado con éxito");
        }
    }
}
