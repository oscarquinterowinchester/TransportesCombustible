package com.appchoferes.nomina.controllers.lorasdb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appchoferes.nomina.models.lorasdb.LlaveDTO;
import com.appchoferes.nomina.repositories.lorasdb.LlavesRepository;

import java.util.List;

@RestController
@RequestMapping("/patios")
public class LlavesController {

    @Autowired
    private LlavesRepository llavesRepository;

    @GetMapping("/getLlavesDia")
    public List<LlaveDTO> getLlavesDia() {
        return llavesRepository.findLlavesDia(); 
    }
}

