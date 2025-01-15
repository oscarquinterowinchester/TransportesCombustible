package com.appchoferes.nomina.controllers.durandb;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.appchoferes.nomina.models.durandb.TipoMovModel;
import com.appchoferes.nomina.services.durandb.TipoMovService;

@RestController
@RequestMapping("/tipomovimiento")
public class TipoMovController {

    @Autowired
    TipoMovService tipoMovService;

    @GetMapping()
    public ArrayList<TipoMovModel> obtenerTipoMov() {
        return tipoMovService.obtenerTipoMov();
    }
}
