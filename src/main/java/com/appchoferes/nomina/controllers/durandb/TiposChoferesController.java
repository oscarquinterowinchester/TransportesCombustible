package com.appchoferes.nomina.controllers.durandb;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.appchoferes.nomina.models.durandb.TiposChoferesModel;
import com.appchoferes.nomina.services.durandb.TiposChoferesService;

@RestController
@RequestMapping("/tiposchoferes")
public class TiposChoferesController {
    @Autowired
    TiposChoferesService tiposChoferesService;

    @GetMapping()
    public ArrayList<TiposChoferesModel> obtenerChoferes() {
        return tiposChoferesService.obtenerChoferes();
    }
}
