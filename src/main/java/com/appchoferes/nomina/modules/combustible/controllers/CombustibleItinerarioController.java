package com.appchoferes.nomina.modules.combustible.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.appchoferes.nomina.modules.combustible.dtos.ItinerarioDTO;
import com.appchoferes.nomina.modules.combustible.services.CombustibleItinerarioService;

@RestController
@RequestMapping("/api/combustible")
public class CombustibleItinerarioController {

    @Autowired
    private CombustibleItinerarioService combustibleItinerarioService;

    @GetMapping("/itinerario-camion")
    public List<ItinerarioDTO> getItinerarioCamion(
            @RequestParam("camionId") Long camionId,
            @RequestParam("fechaAnterior") String fechaAnterior,
            @RequestParam("fechaActual") String fechaActual) {

        return combustibleItinerarioService.getItinerarioCamion(
            camionId, fechaAnterior, fechaActual);
    }

}


