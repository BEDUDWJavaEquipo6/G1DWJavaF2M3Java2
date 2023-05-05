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
				case 3:
					accionesMenu.listarCursos();
					break;
				case 4:
					accionesMenu.promedioTodoslosCursos();
					break;
				case 5:
					accionesMenu.opcionesCurso();
					break;
				case 6:
					System.out.println("Saliendo de la aplicación.");
					break;
				default:
					System.out.println("Opción desconocida.");
			}

		}while(opcionSeleccionada != 6);

	}
}
