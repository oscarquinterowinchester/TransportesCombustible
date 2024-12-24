package com.appchoferes.nomina.modules.combustible.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appchoferes.nomina.modules.combustible.dtos.ChoferDTO;
import com.appchoferes.nomina.modules.combustible.services.ChoferService;

@RestController
@RequestMapping("/api/combustible")
public class ChoferController {

    @Autowired
    private ChoferService choferService;

    @GetMapping("/choferes")
    public List<ChoferDTO> getAllChoferes(){
        return choferService.getAllChoferes();
    }

}

