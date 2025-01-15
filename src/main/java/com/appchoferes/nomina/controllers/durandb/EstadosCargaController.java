package com.appchoferes.nomina.controllers.durandb;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.appchoferes.nomina.models.durandb.EstadosCargaModel;
import com.appchoferes.nomina.services.durandb.EstadosCargaService;

@RestController
@RequestMapping("/estadoscarga")
public class EstadosCargaController {

    @Autowired
    EstadosCargaService estadosCargaService;

    @GetMapping()
    public ArrayList<EstadosCargaModel> obtenerEstados() {
        return estadosCargaService.obtenerEstados();
    }
}
