package com.appchoferes.nomina.controllers.lorasdb;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appchoferes.nomina.models.lorasdb.dtos.ChoferDTO;
import com.appchoferes.nomina.services.lorasdb.ChoferService;

@RestController
@RequestMapping("/combustible")
public class ChoferController {

    @Autowired
    private ChoferService choferService;

    @GetMapping("/choferes")
    public List<ChoferDTO> getAllChoferes() {
        return choferService.getAllChoferes();
    }

}
