package org.bedu.postwork.javase2project.tools;

import org.bedu.postwork.javase2project.model.Curso;
import org.bedu.postwork.javase2project.model.Estudiante;
import org.bedu.postwork.javase2project.model.Materia;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;


@SpringBootTest
@ComponentScan(basePackages = "org.bedu.postwork.javase2project")
@ExtendWith(SpringExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ReporteCalificacionesTest {

    @Autowired
    private ReporteCalificaciones reporteCalificaciones;

    private Materia materia = new Materia();
    private Estudiante estudiante1 = new Estudiante();
    private Estudiante estudiante2 = new Estudiante();
    private Estudiante estudiante3 = new Estudiante();
    private Curso curso = new Curso();

    @BeforeAll
    void SetUp(){
        materia.setNombre("Analisis de datos");
        estudiante1.setNombreCompleto("Fulanito");
        estudiante2.setNombreCompleto("Menganito");
        estudiante3.setNombreCompleto("Perenganito");
        curso.setCiclo('1');
        curso.setMaterias(materia);

        Map<Estudiante, Integer> calificacion = new HashMap<>();
        calificacion.put(estudiante1,10);
        calificacion.put(estudiante2,8);
        calificacion.put(estudiante3,9);

        curso.setCalificaciones(calificacion);
    }

    @Test
    void ListaAlumnosporCalificacion(){
        assertThat(reporteCalificaciones.listaAlumnosPorCalificacion(curso)).containsExactly(entry("Fulanito", 10),
                entry("Perenganito", 9),entry("Menganito", 8));
    }
    @Test
    void listaAlumnosPorEstudiantes(){
        assertThat(reporteCalificaciones.listaAlumnosPorEstudiantes(curso)).containsExactly(entry("Fulanito", 10),
                entry("Menganito", 8),entry("Perenganito", 9));
    }

    @Test
    void listaMaterias(){

    }







}