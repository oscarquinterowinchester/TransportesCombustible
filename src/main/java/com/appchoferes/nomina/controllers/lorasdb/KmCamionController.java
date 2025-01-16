package com.appchoferes.nomina.controllers.lorasdb;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.appchoferes.nomina.models.lorasdb.dtos.KmCamionDTO;
import com.appchoferes.nomina.services.lorasdb.KmCamionService;


@RestController
@RequestMapping("/combustible")
public class KmCamionController {

    @Autowired
    private KmCamionService kmCamionService;

    @GetMapping("/km-camion")
    public List<KmCamionDTO> getKmCamion(
            @RequestParam("camionId") Long camionId,
            @RequestParam("fechaAnterior") String fechaAnterior, 
            @RequestParam("fechaActual") String fechaActual) {
        return kmCamionService.getKmCamion(camionId, fechaAnterior, fechaActual);
    }

}
