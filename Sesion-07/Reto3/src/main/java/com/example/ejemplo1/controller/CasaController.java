package com.example.ejemplo1.controller;

import com.example.ejemplo1.entity.Casa;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
@RequestMapping("/")
public class CasaController {


    @PostMapping("/casa")
    public void recibeCasa(@RequestBody Casa casa){
        log.info(casa.toString());
    }
}
