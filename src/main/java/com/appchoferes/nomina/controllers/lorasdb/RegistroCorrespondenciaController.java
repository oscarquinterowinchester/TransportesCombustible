package com.appchoferes.nomina.controllers.lorasdb;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appchoferes.nomina.models.lorasdb.RegistroCorrespondencia;
import com.appchoferes.nomina.services.lorasdb.RegistroCorrespondenciaServ;

@RestController
@RequestMapping("/patios")
public class RegistroCorrespondenciaController {

    @Autowired
    private RegistroCorrespondenciaServ rCserv;

    @GetMapping("/registros-correspondencia")
    public List<RegistroCorrespondencia> getRegistrosC() {
        return rCserv.getRegistrosC();
    }

}
