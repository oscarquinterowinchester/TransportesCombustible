package com.appchoferes.nomina.controllers.durandb;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.appchoferes.nomina.models.durandb.TiposUnidadModel;
import com.appchoferes.nomina.services.durandb.TiposUnidadService;

@RestController
@RequestMapping("/tiposunidad")
public class TiposUnidadController {

    @Autowired
    TiposUnidadService tiposUnidadService;

    @GetMapping()
    public ArrayList<TiposUnidadModel> obtenerTiposUnidad() {
        return tiposUnidadService.obtenerTiposUnidad();
    }
}
