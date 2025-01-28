package com.appchoferes.nomina.controllers.lorasdb;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appchoferes.nomina.models.lorasdb.dtos.CamionesPatios;
import com.appchoferes.nomina.services.lorasdb.CamionesConCargaService;

@RestController
@RequestMapping("/patios")
public class P_CamionesController {

    @Autowired
    private CamionesConCargaService camionesService;

    @GetMapping("/camiones-patios")
    public List<CamionesPatios> getCamiones() {
        return camionesService.getCamionesDePatios();
    }
}
