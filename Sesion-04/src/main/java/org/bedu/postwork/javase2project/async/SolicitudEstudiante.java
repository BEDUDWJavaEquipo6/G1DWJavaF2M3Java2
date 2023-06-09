package org.bedu.postwork.javase2project.async;

import org.bedu.postwork.javase2project.model.Curso;
import org.bedu.postwork.javase2project.model.Estudiante;

public class SolicitudEstudiante {
    private Estudiante estudiante;
    private Curso curso;

    //a) Constructor que reciba estudiante y curso
    public SolicitudEstudiante(Estudiante estudiante, Curso curso) {
        this.estudiante = estudiante;
        this.curso = curso;
    }

    //b) Getters y setters para ambos parámetros


    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
}
