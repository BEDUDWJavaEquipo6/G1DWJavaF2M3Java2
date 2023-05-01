package org.bedu.postwork.javase2project.persistence;

import org.bedu.postwork.javase2project.model.Curso;
import org.bedu.postwork.javase2project.model.Estudiante;
import org.bedu.postwork.javase2project.model.Materia;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
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

@SpringBootTest
@ComponentScan(basePackages = "org.bedu.postwork.javase2project")
@ExtendWith(SpringExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CursoRepositoryTest {

    @Autowired
    private CursoRepository cursoRepository;
    @Autowired
    private MateriaRepository materiaRepository;

    @Autowired
    private EstudianteRepository estudianteRepository;

    Materia materia;
    Estudiante estudiante;
    Estudiante estudiante2;

    @BeforeAll
    void setUpDatebase(){
        cursoRepository.deleteAll();
        materiaRepository.deleteAll();
        estudianteRepository.deleteAll();

        materia = new Materia();
        materia.setNombre("Base de datos");
        materia = materiaRepository.save(materia);

        estudiante = new Estudiante();
        estudiante.setNombreCompleto("Jose Angel Cordoba");
        estudiante=estudianteRepository.save(estudiante);

        estudiante2 = new Estudiante();
        estudiante2.setNombreCompleto("pacho pantera");
        estudiante2=estudianteRepository.save(estudiante2);


    }

    @Test
    @DisplayName("Guarda un Curso")
    void guarda(){
        Curso curso = new Curso();
        curso.setCiclo('1');
        curso.setMaterias(materia);
        curso = cursoRepository.save(curso);
        assertNotNull(curso.getId());
    }
    @Test
    @DisplayName("Busca por Curso")
    void searchMatchByNames() {

        final char ciclo= '3';
        Curso curso = new Curso();
        curso.setCiclo(ciclo);
        curso.setMaterias(materia);
        Map<Estudiante, Integer> calificacion = new HashMap<>();
        calificacion.put(estudiante,5);
        curso.setCalificaciones(calificacion);
        cursoRepository.save(curso);

        Iterable<Curso> listaCursos = cursoRepository.findAllByCiclo(ciclo);
        assertTrue(listaCursos.iterator().hasNext());

        Curso cursoRecuperado = listaCursos.iterator().next();
        assertEquals(curso, cursoRecuperado);

    }
    @Test
    @DisplayName("Guarda una calificación")
    void guardaCalificaciones(){
        Curso curso = new Curso();
        curso.setCiclo('2');
        curso.setMaterias(materia);

        Map<Estudiante, Integer> calificacion = new HashMap<>();
        calificacion.put(estudiante,10);

        curso.setCalificaciones(calificacion);
        curso = cursoRepository.save(curso);
        assertNotNull(curso.getId());
    }



    @Test
    @DisplayName("Guarda dos calificaciones")
    void guarda2Calificaciones(){
        Curso curso = new Curso();
        curso.setCiclo('4');
        curso.setMaterias(materia);

        Map<Estudiante, Integer> calificacion = new HashMap<>();
        calificacion.put(estudiante,10);
        calificacion.put(estudiante2,8);

        curso.setCalificaciones(calificacion);
        curso = cursoRepository.save(curso);
        assertNotNull(curso.getId());
    }

    /*@Test
    void getCurso(){
        Curso curso = new Curso();
        curso.setCiclo('3');
        curso.setMaterias(materia);

        Map<Estudiante, Integer> calificacion = new HashMap<>();
        calificacion.put(estudiante,10);

        curso.setCalificaciones(calificacion);
        curso = cursoRepository.save(curso);

        curso = cursoRepository.findById(curso.getId()).get();
        assertEquals(4, curso.getId());
    }*/

}