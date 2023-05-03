package org.bedu.postwork.javase2project.persistence;

import org.bedu.postwork.javase2project.model.Curso;
import org.bedu.postwork.javase2project.model.Estudiante;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Map;

public interface CursoRepository extends CrudRepository<Curso, Long> {
    Curso findById(long id);
    Iterable<Curso> findAllByCiclo(char ciclo);
}

