package com.appchoferes.nomina.modules.combustible.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appchoferes.nomina.modules.combustible.dtos.CajasConCargaDTO;
import com.appchoferes.nomina.modules.combustible.services.CajasConCargaService;


@RestController
@RequestMapping("/api/combustible")
public class CajasConCargaController {

    @Autowired
    private CajasConCargaService cajasConCargaService;

    @GetMapping("/cajas-cargas")
    public List<CajasConCargaDTO> getAllCajasConCarga() {
        return cajasConCargaService.getAllCajasConCarga();
    }

    
    @GetMapping("/cajas-cargas/{id}")
    public CajasConCargaDTO getCaja(@PathVariable Long id) {
        return cajasConCargaService.getCaja(id);
    }
}

