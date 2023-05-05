package org.bedu.postwork.javase2project.model;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Map;
import java.util.Objects;

@Entity
@Table(name="cursos")
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "ciclo")
    @Size(max = 4)
    private String ciclo;

    @ManyToOne
    @JoinColumn(name = "materias_fk", referencedColumnName = "id")
    private Materia materias;

    @ElementCollection(fetch=FetchType.EAGER)
    @CollectionTable(name = "cursos_has_estudiantes",joinColumns = {@JoinColumn(name = "cursos_fk", referencedColumnName = "id")})
    @MapKeyJoinColumn(name = "estudiantes_fk", referencedColumnName = "id")
    @Column(name = "calificacion")
    private Map<Estudiante, Integer> calificaciones;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCiclo() {
        return ciclo;
    }

    public void setCiclo(String ciclo) {
        this.ciclo = ciclo;
    }

    public Materia getMaterias() {
        return materias;
    }

    public void setMaterias(Materia materias) {
        this.materias = materias;
    }

    public Map<Estudiante, Integer> getCalificaciones() {
        return calificaciones;
    }

    public void setCalificaciones(Map<Estudiante, Integer> calificaciones) {
        this.calificaciones = calificaciones;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Curso curso = (Curso) o;
        return ciclo == curso.ciclo && Objects.equals(id, curso.id) && Objects.equals(materias, curso.materias);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ciclo, materias);
    }
}

