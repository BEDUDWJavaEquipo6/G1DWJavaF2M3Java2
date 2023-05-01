package org.bedu.postwork.javase2project.multithreading;

import org.bedu.postwork.javase2project.model.Curso;

public class CalculadorPromedioCurso implements Runnable {
    private Curso curso;
    public CalculadorPromedioCurso(Curso curso){
        this.curso = curso;
    }

    @Override
    public void run() {
        System.out.println(curso.getId());
        int suma=0;
        double promedio = 0;
        for (Integer calif: curso.getCalificaciones().values()
             ) {
            suma = suma +calif;

        }
        promedio = suma/curso.getCalificaciones().size();

        System.out.println("la materia es: " + curso.getMaterias().getNombre());
        System.out.println("el promedio es: " + promedio);
    }
}
