package com.example.ejemplo1.controller;

import com.example.ejemplo1.entity.Auto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/autos")
public class AutoController {
    @GetMapping("/saludo")
    public String saluda(){
        return "Hola";
    }
    @PostMapping("/auto")
    public void recibe(@RequestBody Auto auto){
        log.info(auto.toString());

    }
}
