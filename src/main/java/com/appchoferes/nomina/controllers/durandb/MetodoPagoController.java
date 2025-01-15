package com.appchoferes.nomina.controllers.durandb;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.appchoferes.nomina.models.durandb.MetodoPagoModel;
import com.appchoferes.nomina.services.durandb.MetodoPagoService;

@RestController
@RequestMapping("/metodopago")
public class MetodoPagoController {

    @Autowired
    MetodoPagoService metodoPagoService;

    @GetMapping()
    public ArrayList<MetodoPagoModel> obtenerMetodoPago() {
        return metodoPagoService.obtenerMetodoPago();
    }
}
