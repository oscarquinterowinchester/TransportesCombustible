package com.appchoferes.nomina.modules.combustible.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appchoferes.nomina.modules.combustible.dtos.CajaConCargaDTO;
import com.appchoferes.nomina.modules.combustible.services.CajaService;

@RestController
@RequestMapping("/api/combustible")
public class CajaController {

    @Autowired
    private CajaService cajaService;

    @GetMapping("/cajas-cargas")
    public List<CajaConCargaDTO> getAllCajasConCarga() {
        return cajaService.getAllCajasConCarga();
    }

    
}

