package com.appchoferes.nomina.controllers.lorasdb;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appchoferes.nomina.models.lorasdb.AreaCorrespondencia;
import com.appchoferes.nomina.services.lorasdb.AreaCorrespondenciaServ;

@RestController
@RequestMapping("/patios")
public class AreasCorrespondenciaController {

    @Autowired
    private AreaCorrespondenciaServ areaCorrespondenciaServ;

    @GetMapping("/areas-correspondencia")
    public List<AreaCorrespondencia> getAllAreas() {
        return areaCorrespondenciaServ.getAllAreasCorrespondencia();
    }
}
