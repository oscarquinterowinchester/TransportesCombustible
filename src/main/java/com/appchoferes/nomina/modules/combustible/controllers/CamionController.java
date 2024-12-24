package com.appchoferes.nomina.modules.combustible.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appchoferes.nomina.modules.combustible.dtos.CamionConCargaDTO;
import com.appchoferes.nomina.modules.combustible.services.CamionService;

@RestController
@RequestMapping("/api/combustible")
public class CamionController{
    
    @Autowired
    private CamionService camionService;

    @GetMapping("/camiones-cargas")
    public List<CamionConCargaDTO> getAllCamionesConCargas(){
        return camionService.getAllCamionesConCargas();
    }

}
