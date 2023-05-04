package org.bedu.postwork.javase2project.service;

import org.bedu.postwork.javase2project.model.Materia;
import org.bedu.postwork.javase2project.persistence.MateriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MateriaService {

    private final MateriaRepository materiaRepository;

    @Autowired
    public MateriaService(MateriaRepository materiaRepository) {
        this.materiaRepository = materiaRepository;
    }

    public  Materia guardaMateria(Materia materia){
        return materiaRepository.save(materia);
    }

    public Iterable<Materia> getMateria(){
        return materiaRepository.findAll();
    }

}
