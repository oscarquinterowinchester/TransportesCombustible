package com.appchoferes.nomina.controllers.durandb;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.appchoferes.nomina.models.durandb.TarifasPagoModel;
import com.appchoferes.nomina.services.durandb.TarifasPagoService;

@RestController
@RequestMapping("/tarifaspago")
public class TarifasPagoController {

    @Autowired
    TarifasPagoService tarifasPagoService;

    @GetMapping()
    public ArrayList<TarifasPagoModel> obtenerTarifasPago() {
        return tarifasPagoService.obtenerTarifasPago();
    }
}
