package org.bedu.postwork.javase2project.persistence;

import org.bedu.postwork.javase2project.model.Estudiante;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ComponentScan(basePackages = "org.bedu.postwork.javase2project")
@ExtendWith(SpringExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class EstudianteRepositoryTest {
    @Autowired
    private CursoRepository cursoRepository;
    @Autowired
    private EstudianteRepository estudianteRepository;


    @BeforeAll
    void setUpDatabase(){
        cursoRepository.deleteAll();
        estudianteRepository.deleteAll();
    }

    @Test
    @DisplayName("Puede guardar un Estudiante")
    void guarda(){
        Estudiante estudiante = new Estudiante();
        estudiante.setNombreCompleto("Jose Angel Cordoba");
        estudiante=estudianteRepository.save(estudiante);
        assertNotNull(estudiante.getId());
    }

    @Test
    @DisplayName("Busca por nombre del Estudiante")
    void buscarPorNombreEstudiante() {
        final String nombreEstudiante = "Frank G";

        Estudiante estudiante = new Estudiante();
        estudiante.setNombreCompleto(nombreEstudiante);
        estudianteRepository.save(estudiante);

        Iterable<Estudiante> listaEstudiantes = estudianteRepository.findAllByNombreCompleto(nombreEstudiante);
        assertTrue(listaEstudiantes.iterator().hasNext());

        Estudiante estudianteRecuperado = listaEstudiantes.iterator().next();
        assertEquals(estudiante, estudianteRecuperado);
    }

}