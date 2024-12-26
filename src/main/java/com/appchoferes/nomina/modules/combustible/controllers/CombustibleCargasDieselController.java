package com.appchoferes.nomina.modules.combustible.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.appchoferes.nomina.modules.combustible.dtos.CargasDieselDTO;
import com.appchoferes.nomina.modules.combustible.dtos.HistorialAnteriorDTO;
import com.appchoferes.nomina.modules.combustible.services.CombustibleCargasDieselService;

@RestController
@RequestMapping("/api/combustible")
public class CombustibleCargasDieselController {

    @Autowired
    private CombustibleCargasDieselService combustibleCargasDieselService;

    @GetMapping("/historial-cargas")
    public List<CargasDieselDTO> getHistorial(
            @RequestParam("id") Long id, 
            @RequestParam("tipo") Integer tipo) {
        return combustibleCargasDieselService.getHistorialCargas(id, tipo);
    }

    @GetMapping("/historial-anterior")
    public List<HistorialAnteriorDTO> getHistorialAnterior(
            @RequestParam("id") Long id, 
            @RequestParam("fechaActual") String fechaActual) {
        return combustibleCargasDieselService.getHistorialAnterior(id, fechaActual);
    }

}
