package com.appchoferes.nomina.modules.combustible.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appchoferes.nomina.modules.combustible.dtos.CargasDieselDTO;
import com.appchoferes.nomina.modules.combustible.services.CombustibleCargasDieselService;

@RestController
@RequestMapping("/api/combustible")
public class CombustibleCargasDieselController {

    @Autowired
    private CombustibleCargasDieselService combustibleCargasDieselService;

    @GetMapping("/historial-carga/{id}-{tipo}")
    public List<CargasDieselDTO> getHistorial(@PathVariable("id") Long id, @PathVariable("tipo") Integer tipo) {
        return combustibleCargasDieselService.getHistorialCargas(id, tipo);
    }

}
