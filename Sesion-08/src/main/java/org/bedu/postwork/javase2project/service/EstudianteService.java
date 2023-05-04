package org.bedu.postwork.javase2project.service;

import org.bedu.postwork.javase2project.model.Estudiante;
import org.bedu.postwork.javase2project.persistence.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstudianteService {
    private final EstudianteRepository estudianteRepository;

    @Autowired
    public EstudianteService(EstudianteRepository estudianteRepository) {
        this.estudianteRepository = estudianteRepository;
    }

    public Estudiante guardaEstudiante(Estudiante estudiante){
        return estudianteRepository.save(estudiante);
    }

    public Iterable<Estudiante> getEstudiante(){
        return estudianteRepository.findAll();
    }
}
