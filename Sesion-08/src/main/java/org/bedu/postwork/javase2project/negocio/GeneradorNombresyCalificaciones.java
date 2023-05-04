package org.bedu.postwork.javase2project.negocio;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class GeneradorNombresyCalificaciones {

    private Map<String, Integer> estudianteConCalificacion = new HashMap<>();
    public Map<String, Integer> aletorio(int numeroAlumnos){
        Random random = new Random();
        for (int i= 0; i<=numeroAlumnos; i++){
            estudianteConCalificacion.put("Ejemplo" + i, random.nextInt(10) + 1);
        }
        return estudianteConCalificacion;
    }

    public Map<String, Integer> manual(int numeroAlumnos){
        Lector lector = new Lector();
        String nombre;
        int calificacion;
        for (int i= 0; i<numeroAlumnos; i++){
            System.out.println("Ingresa el nombre del estudiante " + (i+1) + ": ");
            nombre = lector.leeDato();
            System.out.println("Ingresa la calificación del estudiante " + (i+1) + ": ");
            calificacion = lector.leeNum();
            estudianteConCalificacion.put(nombre, calificacion);
            lector.leeDato();
        }
        return estudianteConCalificacion;
    }
}
