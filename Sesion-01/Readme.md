
# Postwork 01: Gestión de bases de datos

## 🎩 Objetivo

- Practicar las consultas CRUD sobre la base de datos.
- Crear las entidades y repositorios que usaremos para el proyecto.

## 🎯 Requisitos

- MySQL instalado y configurado
- Apache Maven 3.8.4 o superior
- JDK (o OpenJDK)

## 🚀 Desarrollo

1. Se clonó el proyecto de la carpeta [base].


2. A partir de los diagramas se generaron las entidades/modelosdel proyecto.

    ![Clases](images/Diagrama_de_clases.png)

    ![ER](images/Diagrama_ER.png)

    a. Curso
    
    b. Estudiante
    
    c. Materia

3. También generaron los repositorios correspondientes:

    a. CursoRepository
    
    b. EstudianteRepository

    c. MateriaRepository

### 🚀 Instrucciones de uso.

1. Descarga el archivo correspondiente al Postwork 4.



2. Ejecuta el proyecto con el comando:
```
mvn spring-boot:run
```

   ![Salida del comando enejecuión](images/Sesion1-mvnSpring-boot-run1-bsfS8.png)

   ![Estructura de archivos del proyecto](images/Sesion1-mvnSpring-boot-run2-bsfS8.png)

3. Analiza los casos de prueba desarrollados:

    - Crear y almacenar (Por lo menos uno de cada uno):
        - Estudiante
        - Materia
        - Curso
        
    - Una vez creado el curso, agregar la calificación del estudiante.


4. Ejecuta las pruebas con los siguientes comandos:

```
mvn test
```
![All Tests at once](images/Sesion1-mvn-testAll1-bsfS8.png)

5. Observa los resultados de cada prueba ejecutada.
```
mvn test -D "MateriaRepositoryTest"
```
![MateriaRepositoryTest](images/Sesion1-mvn-testMateriaRespositoryTest1-bsfS8.png)
![MateriaRepositoryTest](images/Sesion1-mvn-testMateriaRespositoryTest2-bsfS8.png)
![MateriaRepositoryTest](images/Sesion1-mvn-testMateriaRespositoryTest3-bsfS8.png)
```
mvn test -D "EstudianteRepositoryTest"
```
![](images/Sesion1-mvn-testEstudianteRespositoryTest1-bsfS8.png)
![](images/Sesion1-mvn-testEstudianteRespositoryTest2-bsfS8.png)
![](images/Sesion1-mvn-testEstudianteRespositoryTest3-bsfS8.png)
```
mvn test -D "CursoRepositoryTest"
```
![](images/Sesion1-mvn-testCursoRespositoryTest1-bsfS8.png)

![](images/Sesion1-mvn-testCursoRespositoryTest2-bsfS8.png)

![](images/Sesion1-mvn-testCursoRespositoryTest3-bsfS8.png)

![](images/Sesion1-mvn-testCursoRespositoryTest4-bsfS8.png)

![](images/Sesion1-mvn-testCursoRespositoryTest5-bsfS8.png)

![](images/Sesion1-mvn-testCursoRespositoryTest6-bsfS8.png)

![](images/Sesion1-mvn-testCursoRespositoryTest7-bsfS8.png)

![](images/Sesion1-mvn-testCursoRespositoryTest8-bsfS8.png)

6. Para finalizar, recuerda la siguiente información.
    - @ElementCollection:
Nos permite guardar una lista de valores en forma de entidad.     
    - @CollectionTable:
Especifica la tabla que se usa para realizar el *map* de una colección de atributos básicos.    
    - @MapKeyJoinColumn.
Especifica el *mapping* hacia una entidad que representa la llave.  

<br/>

[Siguiente ](../Sesion-02/Readme.md)(Sesión 02)

[Regresar a root ](../Readme.md)(Principal)