package org.bedu.postwork.javase2project.async;

import org.bedu.postwork.javase2project.model.Curso;
import org.bedu.postwork.javase2project.model.Estudiante;
import org.bedu.postwork.javase2project.model.Materia;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class InscripcionAlumnos {
    public static void main(String[] args) {
        //Generará cursos y alumnos aleatorios
        Random rand = new Random();

        ReceptorSolicitudes eventLoop = new ReceptorSolicitudes(solicitud -> {
            if (solicitud.getEstudiante() == null || solicitud.getCurso() == null) {
                System.out.println("Datos incorrectos, ingrese de nuevo");
            }
            System.out.println("Confirmación de inscripción: " + solicitud.getEstudiante().getNombreCompleto()
                    + " ha quedado inscrito en " + solicitud.getCurso().getMaterias().getNombre());
        });

        //Registro
        eventLoop.iniciar();
        SolicitudEstudiante[] solicitudes = creaSolicitudes();

        for (SolicitudEstudiante E : solicitudes) {
            eventLoop.registrarEvento(E);
            try {
                TimeUnit.MILLISECONDS.sleep(rand.nextInt(200));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        eventLoop.detener();
    }

    //Creación de los cursos
    private static SolicitudEstudiante[] creaSolicitudes() {
        Random rnd = new Random();
        Curso[] cursos = new Curso[]{
                crearCurso(rnd, "Fisica I", 1),
                crearCurso(rnd, "Algebra avanzada", 2),
                crearCurso(rnd, "Estadistica", 3),
                crearCurso(rnd, "Ciencias sociales", 4)
        };

    //Generación de estudiantes aleatorios
        SolicitudEstudiante[] solicitudes = new SolicitudEstudiante[20];
        for (int i = 0; i < 20; i++) {
            Estudiante e = new Estudiante();
            e.setNombreCompleto("BEDU " + i);
            e.setId((long)i);

            solicitudes[i] = new SolicitudEstudiante(e, cursos[rnd.nextInt(cursos.length)]);
        }
        return solicitudes;
    }

    private static Curso crearCurso(Random rand, String nombreMateria, long idCurso) {
        Curso curso1 = new Curso();
        curso1.setId(idCurso);
        Materia materia1 = new Materia();
        materia1.setNombre(nombreMateria);
        curso1.setMaterias(materia1);
        return curso1;
    }
}






