package com.appchoferes.nomina.controllers.durandb;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.appchoferes.nomina.models.durandb.PaisesModel;
import com.appchoferes.nomina.services.durandb.PaisesService;

@RestController
@RequestMapping("/paises")
public class PaisesController {

    @Autowired
    PaisesService paisesService;

    @GetMapping()
    public ArrayList<PaisesModel> obtenerPaises() {
        return paisesService.obtenerPaises();
    }

}
