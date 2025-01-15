package com.appchoferes.nomina.controllers.durandb;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.appchoferes.nomina.models.durandb.MetodoPagoSatModel;
import com.appchoferes.nomina.services.durandb.MetodoPagoSatService;

@RestController
@RequestMapping("/metodopagosat")
public class MetodoPagoSatController {

    @Autowired
    MetodoPagoSatService metodoPagoSatService;

    @GetMapping()
    public ArrayList<MetodoPagoSatModel> obtenerMetodoPago() {
        return metodoPagoSatService.obtenerMetodoPago();
    }
}
