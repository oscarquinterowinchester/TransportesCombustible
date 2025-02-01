package com.appchoferes.nomina.controllers.lorasdb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.appchoferes.nomina.services.lorasdb.ContenedorPatioServ;

import java.util.Map;

@RestController
@RequestMapping("/patios")
public class P_ContenedorController {

    @Autowired
    private ContenedorPatioServ service;

    @GetMapping("/contenedores-patio")
    public Map<String, Object> getContenedores(@RequestParam int patioId, @RequestParam int usuarioId) {
        return service.obtenerContenedores(patioId, usuarioId);
    }

    @GetMapping("/entrada")
    public Object getContenedorEntrada(
            @RequestParam(required = false) Long itinerarioId,
            @RequestParam(required = false) String contenedor,
            @RequestParam Integer tipo) {

        return service.getContenedorEntrada(itinerarioId, contenedor, tipo);
    }

}
