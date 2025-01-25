package com.appchoferes.nomina.controllers.lorasdb;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appchoferes.nomina.models.lorasdb.TipoCorrespondencia;
import com.appchoferes.nomina.services.lorasdb.TipoCorrespondeciaServ;

@RestController
@RequestMapping("/patios")
public class TipoCorrespondenciaController {

    @Autowired
    private TipoCorrespondeciaServ tipoCorrespondeciaServ;

    @GetMapping("/tipos-correspondencia")
    public List<TipoCorrespondencia> getAllTipoCorrespondencia() {
        return tipoCorrespondeciaServ.getAllTiposCorrespondencia();
    }

}
