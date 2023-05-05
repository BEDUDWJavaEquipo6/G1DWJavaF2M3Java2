package org.bedu.postwork.javase2project.service;

import org.bedu.postwork.javase2project.model.Curso;
import org.bedu.postwork.javase2project.model.Estudiante;
import org.bedu.postwork.javase2project.model.Materia;
import org.bedu.postwork.javase2project.persistence.CursoRepository;
import org.bedu.postwork.javase2project.persistence.EstudianteRepository;
import org.bedu.postwork.javase2project.persistence.MateriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreadorService {

    private final MateriaRepository materiaRepository;
    private final EstudianteRepository estudianteRepository;
    private final CursoRepository cursoRepository;
    @Autowired
    public CreadorService(MateriaRepository materiaRepository, EstudianteRepository estudianteRepository,
                          CursoRepository cursoRepository){
        this.materiaRepository= materiaRepository;
        this.estudianteRepository = estudianteRepository;
        this.cursoRepository = cursoRepository;
    }

    public Materia guardaMateria(Materia materia){
        return materiaRepository.save(materia);
    }

    public Iterable<Materia> getMateria(){
        return materiaRepository.findAll();
    }

    public Estudiante guardaEstudiante(Estudiante estudiante){
        return estudianteRepository.save(estudiante);
    }

    public Iterable<Estudiante> getEstudiante(){
        return estudianteRepository.findAll();
    }

    public Curso guardaCurso(Curso curso){
        return cursoRepository.save(curso);
    }

    public Iterable<Curso> getCurso(){
        return cursoRepository.findAll();
    }

    public Curso getCursoById(Long id){
        return cursoRepository.findById(id).get();
    }


}
