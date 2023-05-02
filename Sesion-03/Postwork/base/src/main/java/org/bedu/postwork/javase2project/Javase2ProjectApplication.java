package org.bedu.postwork.javase2project;

import org.bedu.postwork.javase2project.model.Curso;
import org.bedu.postwork.javase2project.model.Materia;
import org.bedu.postwork.javase2project.multithreading.CalculadorPromedioCurso;
import org.bedu.postwork.javase2project.multithreading.Postwork2;
import org.bedu.postwork.javase2project.service.CreadorService;
import org.bedu.postwork.javase2project.tools.ReporteCalificaciones;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@SpringBootApplication
public class Javase2ProjectApplication implements CommandLineRunner {

	@Autowired
	private Postwork2 postwork2;
	@Autowired
	private CreadorService creadorService;
	@Autowired
	private ReporteCalificaciones reporteCalificaciones;

	public static void main(String[] args) {
		SpringApplication.run(Javase2ProjectApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {


		//curso.getCalificaciones().forEach((k, v) -> System.out.println(k + ":" + v));

		/*Curso curso1 = new Curso();
		Curso curso2 = new Curso();
		Curso curso3 = new Curso();
		Curso curso4 = new Curso();


		ExecutorService pool = Executors.newCachedThreadPool(); // creamos un pool preconfigurado
		String [] nombres = {"Pruebas", "Estructura de datos", "Software","Automatas"};
		char[] ciclos = {'1','2','3','4'};

		List<Curso> cursos = new ArrayList<>();
		cursos.add(curso1);cursos.add(curso2);cursos.add(curso3);cursos.add(curso4);
		Iterator<Curso> c = cursos.iterator();
		for (int i=0; i<4; i++) {
			pool.execute(new CalculadorPromedioCurso(postwork2.CrearCurso(
					c.next(),  nombres[i], "Marco polo",ciclos[i]
			))); //
		}
		System.out.println("Estado del pool antes de apagar: isShutdown()=" + pool.isShutdown() + ", isTerminated()=" + pool.isTerminated());
		pool.shutdown();
		System.out.println("Estado del pool después de apagar: isShutdown()=" + pool.isShutdown() + ", isTerminated()=" + pool.isTerminated());
		+/
		 */


		//System.out.println(reporteCalificaciones.getCurso(28).getMaterias().getNombre());


		//reporteCalificaciones.listaMaterias();
		//reporteCalificaciones.listaAlumnosPorEstudiantes(32);


	}
}
