package com.appchoferes.nomina.controllers.durandb;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.appchoferes.nomina.models.durandb.TipoOperacionModel;
import com.appchoferes.nomina.services.durandb.TipoOperacionService;

@RestController
@RequestMapping("/tipooperacion")
public class TipoOperacionController {
    @Autowired
    TipoOperacionService tipoOperacionService;

    @GetMapping()
    public ArrayList<TipoOperacionModel> obtenerTipoOperacion() {
        return tipoOperacionService.obtenerTipoOperacion();
    }
}
