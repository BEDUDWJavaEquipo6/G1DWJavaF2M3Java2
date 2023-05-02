# Postwork 03

## 🎩 Objetivo

- Practicar lo aprendido sobre programación funcional.
- Hacer uso de la programación funcional para generar y ordenar una lista de datos (descendente y ascendente).

## 🎯 Requisitos

- MySQL instalado y configurado
- Apache Maven 3.8.4 o superior
- JDK (o OpenJDK)

## 🚀 Desarrollo

1. Sobre el postwork 2, creamos un nuevo package con el nombre de **tools**
y en el, la clase **ReporteCalificaciones** que se encarga de:

    - Generar la lista
    - Ordenar alfabéticamente (Curso)
    - Ordenar por calificaciones (Descendente)
    - utilizando ***map, sort, collect**

2. También se generaron las pruebas **ReporteCalificacionesTest** para generar:
que ejecutamos con el comando: 

   ```
   mvn test
   mvn test -D "ReporteCalificacionesTest"
   ```

   Estas pruebas generan:

    - Materia
    - Estudiantes (Por lo menos tres)
    - Curso
    - Enviar la información a la clase creada en el paso tres
    - Ordena alfabéticamente (Curso)

   ![](images/prueba%20exitosa%20lista%20alumnos%20por%20calificacion%20descendente.png) 
   
    - Ordena por calificaciones (Descendente)

   ![](images/prueba%20exitosa%20lista%20alumnos%20por%20calificacion%20descendente.png)
    
<br/>

[Regresar ](../Readme.md)(Sesión 02)

[Siguiente ](../Sesion-04/Readme.md)(Sesión 04)
