package com.appchoferes.nomina.modules.combustible.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appchoferes.nomina.modules.combustible.dtos.MetodoPagoDTO;
import com.appchoferes.nomina.modules.combustible.services.MetodoPagoService;

@RestController
@RequestMapping("/api/combustible")
public class MetodoPagoController {
    
    @Autowired
    private MetodoPagoService metodoPagoService;

    @GetMapping("/metodos-pago")
    public List<MetodoPagoDTO> getMetodosPago(){
        return metodoPagoService.getMetodosPago();
    }
}
