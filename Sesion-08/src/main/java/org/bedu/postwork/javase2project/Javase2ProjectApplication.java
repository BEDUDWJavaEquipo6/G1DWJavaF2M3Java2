package org.bedu.postwork.javase2project;

import org.bedu.postwork.javase2project.model.Curso;
import org.bedu.postwork.javase2project.multithreading.CalculadorPromedioCurso;
import org.bedu.postwork.javase2project.multithreading.Postwork2;
import org.bedu.postwork.javase2project.negocio.AccionesMenu;
import org.bedu.postwork.javase2project.negocio.GeneradorNombresyCalificaciones;
import org.bedu.postwork.javase2project.negocio.Lector;
import org.bedu.postwork.javase2project.negocio.Menu;
import org.bedu.postwork.javase2project.service.Postwork2ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SpringBootApplication
public class Javase2ProjectApplication implements CommandLineRunner {

	@Autowired
	private Postwork2ServiceImpl postwork2;
	@Autowired
	private AccionesMenu accionesMenu;

	public static void main(String[] args) {
		SpringApplication.run(Javase2ProjectApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {

		Menu menu = new Menu();
		Lector lector = new Lector();


		byte opcionSeleccionada = 0;

		do {
			menu.muestraOpciones();
			System.out.println("Selecciona una opción: ");
			opcionSeleccionada = lector.leeOpcion();

			System.out.printf("%n%nLa opción seleccionada es: %d%n", opcionSeleccionada);

			switch (opcionSeleccionada) {
				case 1:
					accionesMenu.cargaManual();
					break;
				case 2:
					accionesMenu.cargaArchivo();
					break;
				/*case 3:
					lista.verTareasDeLista();
					break;
				case 4:
					lista.actualizarListaDeTareas();
					break;
				case 5:
					lista.eliminarListaDeTareas();
					break;*/
				case 6:
					//lista.guardarTareas();
					System.out.println("Saliendo de la aplicación.");
					break;
				default:
					System.out.println("Opción desconocida.");
			}

		}while(opcionSeleccionada != 6);



/*		Curso curso1 = new Curso();
		Curso curso2 = new Curso();
		Curso curso3 = new Curso();
		Curso curso4 = new Curso();

		Map<String, Integer> estudianteConCalificacion = new HashMap<>();

		GeneradorNombresyCalificaciones generadorNombresyCalificaciones = new GeneradorNombresyCalificaciones();


		ExecutorService pool = Executors.newCachedThreadPool();
		String [] nombres = {"Pruebas", "Estructura de datos", "Software","Automatas"};
		String[] ciclos = {"1","2","3","4"};

		estudianteConCalificacion = generadorNombresyCalificaciones.aletorio(5);

		List<Curso> cursos = new ArrayList<>();
		cursos.add(curso1);cursos.add(curso2);cursos.add(curso3);cursos.add(curso4);
		Iterator<Curso> c = cursos.iterator();
		for (int i=0; i<4; i++) {
			pool.execute(new CalculadorPromedioCurso(postwork2.CrearCurso(
					c.next(),  nombres[i], estudianteConCalificacion,ciclos[i]
			))); //
		}
		System.out.println("Estado del pool antes de apagar: isShutdown()=" + pool.isShutdown() + ", isTerminated()=" + pool.isTerminated());
		pool.shutdown();


		System.out.println("Estado del pool después de apagar: isShutdown()=" + pool.isShutdown() + ", isTerminated()=" + pool.isTerminated());
*/


	}
}
