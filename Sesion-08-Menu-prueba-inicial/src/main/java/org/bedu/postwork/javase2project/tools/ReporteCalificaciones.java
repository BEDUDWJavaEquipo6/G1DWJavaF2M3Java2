package org.bedu.postwork.javase2project.tools;

import org.bedu.postwork.javase2project.model.Curso;
import org.bedu.postwork.javase2project.model.Estudiante;
import org.bedu.postwork.javase2project.model.Materia;
import org.bedu.postwork.javase2project.service.CreadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import javax.persistence.criteria.CriteriaBuilder;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
public class ReporteCalificaciones {
    @Autowired
    private CreadorService creadorService;


    public Map<Long, String> listaMateriasconId(){
        Iterable<Curso> cursos = creadorService.getCurso();

        Map<Long, String> valores = new LinkedHashMap<>();

        for (Curso curso: cursos
             ) {
             valores.put(curso.getId(), curso.getMaterias().getNombre());
        }

        return valores;
    }

    public Map<String, Integer> listaAlumnosPorCalificacion(Curso curso){
            Map<String, Integer> valores = new LinkedHashMap<>();
            curso.getCalificaciones().entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                    .forEach(entry -> {
                valores.put(entry.getKey().getNombreCompleto(), entry.getValue());
                    });

        return valores;
    }

    public Map<String, Integer> listaAlumnosPorEstudiantes(Curso curso){

        Map<String, Integer> valores = new TreeMap<>();
        curso.getCalificaciones().entrySet().stream()
                .forEach(entry -> {
                    valores.put(entry.getKey().getNombreCompleto(), entry.getValue());
                });

        return valores;
    }


}
