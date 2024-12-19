package com.appchoferes.nomina.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.appchoferes.nomina.dtos.VistaCargaCamion;
import com.appchoferes.nomina.services.VistaCargaCamionService;

@RestController
@RequestMapping("/diesel")
public class VistaCargaCamionController {
    @Autowired
    VistaCargaCamionService vistaCargaCamionService;

    @GetMapping("")
    public VistaCargaCamion getvVistaCargaCamion(@RequestParam String choferId, @RequestParam String dbType){
        return vistaCargaCamionService.getVistaCargaCamion(choferId, dbType);
    }
}
