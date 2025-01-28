package com.appchoferes.nomina.controllers.lorasdb;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appchoferes.nomina.models.lorasdb.Chofer;
import com.appchoferes.nomina.services.lorasdb.ChoferService;

@RestController
@RequestMapping("/patios")
public class P_ChoferesController {

    @Autowired
    private ChoferService choferService;

    @GetMapping("/choferes-patios")
    public List<Chofer> getChoferesPatios() {
        return choferService.getChoferesPatios();
    }

}
