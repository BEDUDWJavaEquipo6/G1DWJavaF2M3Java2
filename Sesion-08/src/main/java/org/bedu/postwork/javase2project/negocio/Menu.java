package org.bedu.postwork.javase2project.negocio;

public class Menu {
    public void muestraOpciones() {
        System.out.println("\n==SELECCIONA UNA OPCIÓN==\n");
        System.out.println("1. Carga Manual");
        System.out.println("2. Carga por archivo");
        System.out.println("3. Listar cursos");
        System.out.println("4. Ver promedio de todos los cursos");
        System.out.println("5. Opciones del curso");
        System.out.println("6. Salir");
    }

    public void muestraOpcionesCursos() {
        System.out.println("\n==SELECCIONA UNA OPCIÓN==\n");
        System.out.println("1. Listar estudiantes en orden alfabetico");
        System.out.println("2. Listar estudiantes por calificación descendente");
        System.out.println("3. Ver promedio de calificaciones");
        System.out.println("4. Regresar");
    }
}
