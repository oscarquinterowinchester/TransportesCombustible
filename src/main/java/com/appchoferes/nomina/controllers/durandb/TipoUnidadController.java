package com.appchoferes.nomina.controllers.durandb;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.appchoferes.nomina.models.durandb.TipoUnidadModel;
import com.appchoferes.nomina.services.durandb.TipoUnidadService;

@RestController
@RequestMapping("/tipo-unidad")
public class TipoUnidadController {

    @Autowired
    TipoUnidadService tipoUnidadService;

    @GetMapping()
    public ArrayList<TipoUnidadModel> obtenerTipoUnidad() {
        return tipoUnidadService.obtenerTipoUnidad();
    }

}
