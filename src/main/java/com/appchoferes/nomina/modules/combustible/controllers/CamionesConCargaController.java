package com.appchoferes.nomina.modules.combustible.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appchoferes.nomina.modules.combustible.dtos.CamionesConCargaDTO;
import com.appchoferes.nomina.modules.combustible.services.CamionesConCargaService;

@RestController
@RequestMapping("/api/combustible")
public class CamionesConCargaController{
    
    @Autowired
    private CamionesConCargaService camionesConCargaService;

    @GetMapping("/camiones-cargas")
    public List<CamionesConCargaDTO> getAllCamionesConCargas(){
        return camionesConCargaService.getAllCamionesConCargas();
    }


    @GetMapping("/camiones-cargas/{id}")
    public CamionesConCargaDTO getCamion(@PathVariable Long id){
        return camionesConCargaService.getCamion(id);
    }

    

}
