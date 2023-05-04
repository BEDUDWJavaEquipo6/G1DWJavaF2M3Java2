package org.bedu.postwork.javase2project.service;

import org.bedu.postwork.javase2project.model.Curso;
import org.bedu.postwork.javase2project.persistence.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CursoService {
    private final CursoRepository cursoRepository;

    @Autowired
    public CursoService(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    public Curso guardaCurso(Curso curso){
        return cursoRepository.save(curso);
    }

    public Iterable<Curso> getCurso(){
        return cursoRepository.findAll();
    }
}
