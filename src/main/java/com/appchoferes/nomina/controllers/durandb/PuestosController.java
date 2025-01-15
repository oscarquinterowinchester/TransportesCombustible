package com.appchoferes.nomina.controllers.durandb;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.appchoferes.nomina.models.durandb.PuestosModel;
import com.appchoferes.nomina.services.durandb.PuestosService;

@RestController
@RequestMapping("/puestos")
public class PuestosController {

    @Autowired
    PuestosService puestosService;

    @GetMapping()
    public ArrayList<PuestosModel> obtenerPuestos() {
        return puestosService.obtenerPuestos();
    }
}
