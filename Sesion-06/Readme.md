# Postwork 06: Clases genéricas

## 🎩 Objetivo

- Aplicar los conocimientos de Generics implementanco un MergeSortAlgorithm

## 🚀 Desarrollo

Uno de los principales usos de Generics es poder implementar algoritmos independientes de sus parámetros.

Revisamos la del algoritmo [Merge Sort](https://www.tutorialspoint.com/data_structures_algorithms/merge_sort_algorithm.htm)
para hacer implementación del algoritmo dentro del package tools en la clase MergeSortAlgorithm.

<br/>

1. Que se  encargará de ordenar de dos maneras diferentes y mezclar los dos ordenamientos.

2. El primer método de ordenamiento será con Comparable<t>.

3. El segundo ordenamiento será con List<T>.

4. Un método  merge que mezclará las listas ordenadas.

5. Se agregaron los test para la clase MergeSortAlgorithm.

    - Donde generamos una colección con cien mil números aleatorios y dos test: 
    
        - Ordenar una colección de enteros
        
        - Ordenar una colección con un comparador

6. Ejecutamos los test con el siquiente commando:
```
   mvn test -Dtest="MergeSortAlgorithmTest"
``` 
Adjuntamos la respuesta del mismo:
   ![Prueba Sesion6 MergeSortAlgorithmTest
   ](images/Sesion6_bfS8.png)

<br/>

## ✅ Checklist 

Asegúrate que el postwork contenga todo lo siguiente, ya que esto se evaluará al término del módulo.

- [✅] MergeSortAlgorithm tiene un método que ordena por números números naturales con un Comparable<t>.

- [✅] La clase MergeSortAlgorithm contiene un método que ordena una colección con un comparador.

- [✅] MergeSortAlgorithm tiene un método para mezclar los dos tipos de ordenamiento.

- [✅] La prueba MergeSortAlgorithmTest genera y agreguen cien mil números aleatorios a una lista.

- [✅] Existen dos test para ejecutar los dos tipos de sort creados en la clase MergeSortAlgorithm.

<br/>
RECUERDA REVISAR ANTES DE ENTREGAR QUE ESTAS LIGAS FUNCIONEN

[Regresar ](Postwork/Readme.md)(Sesión 06)

[Siguiente ](../../Sesion-07/Readme.md)(Sesión 07)