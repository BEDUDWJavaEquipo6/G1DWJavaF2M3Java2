package org.bedu.postwork.javase2project.multithreading;

import org.bedu.postwork.javase2project.model.Curso;
import org.bedu.postwork.javase2project.negocio.GeneradorNombresyCalificaciones;
import org.bedu.postwork.javase2project.service.CreadorService;
import org.bedu.postwork.javase2project.service.Postwork2ServiceImpl;
import org.bedu.postwork.javase2project.tools.ReporteCalificaciones;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
@Controller
public class ExecutorPool {

    private final Postwork2ServiceImpl postwork2Service;
    private final ReporteCalificaciones reporteCalificaciones;
    private final CreadorService creadorService;

    @Autowired
    public  ExecutorPool(Postwork2ServiceImpl postwork2Service, ReporteCalificaciones reporteCalificaciones,
                         CreadorService creadorService){
        this.postwork2Service = postwork2Service;
        this.reporteCalificaciones = reporteCalificaciones;
        this.creadorService = creadorService;

    }

    public void executarPool(){
        Iterable<Curso> cursos = creadorService.getCurso();
        ExecutorService pool = Executors.newCachedThreadPool();
        Iterator<Curso> c = cursos.iterator();
        for (Curso curso: cursos
             ) {
            pool.execute(new CalculadorPromedioCurso(curso));

        }
        pool.shutdown();

        try {
            long tiempoLimiteMs = 100;
            System.out.println("Esperando que los hilos finalicen en " + tiempoLimiteMs + "ms...");

            boolean terminaron = pool.awaitTermination(tiempoLimiteMs, TimeUnit.MILLISECONDS);
            System.out.println("¿Terminaron nuestros hilos? " +  terminaron);

            if(!terminaron){
                System.out.println("Llamando a shutdownNow()...");
                List<Runnable> pendientes = pool.shutdownNow();
                System.out.println(pendientes.size() + " hilos pendientes");
                terminaron = pool.awaitTermination(tiempoLimiteMs, TimeUnit.MILLISECONDS);

                if(!terminaron){
                    System.out.println("Aún hay hilos pendientes");
                }
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
