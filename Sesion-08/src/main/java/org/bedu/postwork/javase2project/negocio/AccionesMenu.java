package org.bedu.postwork.javase2project.negocio;

import org.bedu.postwork.javase2project.model.Curso;
import org.bedu.postwork.javase2project.multithreading.ExecutorPool;
import org.bedu.postwork.javase2project.reactive.CalcularPromedioCursoRx;
import org.bedu.postwork.javase2project.service.Postwork2ServiceImpl;
import org.bedu.postwork.javase2project.tools.ReporteCalificaciones;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Controller
public class AccionesMenu {


    private GeneradorNombresyCalificaciones generadorNombresyCalificaciones = new GeneradorNombresyCalificaciones();
    private LeerArchivo leerArchivo = new LeerArchivo();
    private final Postwork2ServiceImpl postwork2Service;
    private final ReporteCalificaciones reporteCalificaciones;
    private final ExecutorPool executorPool;
    private final CalcularPromedioCursoRx calcularPromedioCursoRx;

    @Autowired
    public AccionesMenu(Postwork2ServiceImpl postwork2Service, ReporteCalificaciones reporteCalificaciones,
                        ExecutorPool executorPool, CalcularPromedioCursoRx calcularPromedioCursoRx){
        this.postwork2Service = postwork2Service;
        this.reporteCalificaciones = reporteCalificaciones;
        this.executorPool = executorPool;
        this.calcularPromedioCursoRx = calcularPromedioCursoRx;

    }

    private String ciclo;
    private String nombreMateria;
    private String nombreAlumno;
    private  int calificacion;
    private int numeroEstudiantes;
    private Map<String, Integer> estudianteConCalificacion = new LinkedHashMap<>();
    private Map<String, Integer> datosArchivo = new LinkedHashMap<>();
    private Curso curso = new Curso();
    private Lector  lector = new Lector();


    public void cargaManual(){
        System.out.println("Ciclo:");
        ciclo = lector.leeDato();
        System.out.println("Nombre materia");
        nombreMateria = lector.leeDato();
        System.out.println("Número de estudiantes a ingresar: ");
        numeroEstudiantes = lector.leeNum();
        estudianteConCalificacion = generadorNombresyCalificaciones.manual(numeroEstudiantes);
        guardaCurso(curso,nombreMateria,estudianteConCalificacion,ciclo);
    }

    public void cargaArchivo(){
        int primeraLinea =0;
        System.out.println("Ingresa la ruta del archivo");
        String ruta = lector.leeDato();
        datosArchivo = leerArchivo.datosArchivo(ruta);
        for (Map.Entry<String, Integer> datos : datosArchivo.entrySet()){
            if(primeraLinea<=0){
                nombreMateria = datos.getKey();
                ciclo = datos.getValue().toString();
            }else {
                estudianteConCalificacion.put(datos.getKey(), datos.getValue());
            }
            primeraLinea++;
        }
        guardaCurso(curso,nombreMateria,estudianteConCalificacion,ciclo);
    }

    public void listarCursos(){
        Map<Long, String> materias = new LinkedHashMap<>();
        materias = reporteCalificaciones.listaMateriasconId();
        materias.entrySet().stream()
                .forEach(materia -> System.out.println("Id: " + materia.getKey() + " Nombre: " + materia.getValue()));

    }

    public void promedioTodoslosCursos(){
        executorPool.executarPool();
    }

    public void opcionesCurso(){
        Menu menu = new Menu();
        System.out.println("Selecciona el ID de la materia: ");
        listarCursos();
        Long seleccion = lector.leeId();
        curso = postwork2Service.findCursoById(seleccion);
        menu.muestraOpcionesCursos();
        byte opcionSeleccionada = lector.leeOpcion();

        switch (opcionSeleccionada) {
            case 1:
                estudianteConCalificacion = reporteCalificaciones.listaAlumnosPorEstudiantes(curso);
                estudianteConCalificacion.entrySet().stream()
                        .forEach(estudiante-> System.out.println(
                                "Nombre: " + estudiante.getKey() + " Calificación: " + estudiante.getValue()
                        ));
                break;
            case 2:
                estudianteConCalificacion = reporteCalificaciones.listaAlumnosPorCalificacion(curso);
                estudianteConCalificacion.entrySet().stream()
                        .forEach(estudiante-> System.out.println(
                                "Nombre: " + estudiante.getKey() + " Calificación: " + estudiante.getValue()
                        ));
                break;
            case 3:
                System.out.print("Promedio de la materia: " + curso.getMaterias().getNombre() + ": ");
                calcularPromedioCursoRx.calcularPromedio(curso).subscribe(System.out::println);
                break;
            case 4:
                break;
            default:
                System.out.println("Opción desconocida.");
        }


    }

    public void guardaCurso(Curso curso, String nombreMateria, Map<String, Integer>estudianteConCalificacion, String ciclo){
        curso = postwork2Service.CrearCurso(curso,nombreMateria,estudianteConCalificacion,ciclo);
        if(!curso.getId().equals(null)){
            System.out.println("Curso guardado con éxito");
        }
    }
}
