package com.example.ejemplo1.controller;

import com.example.ejemplo1.entity.Empleado;
import com.example.ejemplo1.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping("/empleados")
public class EmpleadoController {
    @Autowired
    private EmpleadoRepository empleadoRepository;
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    private Flux<Empleado> getAllEmpleados(){
        return empleadoRepository.findAll();
    }
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    private Mono<Empleado> getEmpleadoById(@PathVariable("id") String id){
        return empleadoRepository.findById(id);
    }
    @PostMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    private Mono<Empleado> createEmpleado(@RequestBody Empleado empleado){
        return empleadoRepository.save(empleado);
    }
   /*@PutMapping("/update/{id}")
   @ResponseStatus(HttpStatus.OK)
    private Mono<Empleado> putEmpleado(@PathVariable("id") String id,@RequestBody Empleado empleado){
        return empleadoRepository.update(empleado);
    }*/

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    private Mono<Void> deleteEmpleado(@PathVariable("id") String id){
        return empleadoRepository.deleteById(id);
    }
    @DeleteMapping("/delete")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    private Mono<Void> deleteAllEmpleados(){
        return empleadoRepository.deleteAll();
    }
}
