package org.bedu.postwork.javase2project.persistence;

import org.bedu.postwork.javase2project.model.Materia;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MateriaRepository extends CrudRepository<Materia, Long> {
}
