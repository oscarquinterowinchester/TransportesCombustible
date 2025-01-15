package com.appchoferes.nomina.controllers.durandb;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.appchoferes.nomina.models.durandb.TamañoModel;
import com.appchoferes.nomina.services.durandb.TamañoService;

@RestController
@RequestMapping("/tamano")
public class TamañoController {

    @Autowired
    TamañoService tamañoService;

    @GetMapping()
    public ArrayList<TamañoModel> obtenerTamaño() {
        return tamañoService.obtenerTamaño();
    }
}
