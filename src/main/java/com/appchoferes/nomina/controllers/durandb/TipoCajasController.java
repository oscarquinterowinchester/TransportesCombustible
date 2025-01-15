package com.appchoferes.nomina.controllers.durandb;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.appchoferes.nomina.models.durandb.TipoCajasModel;
import com.appchoferes.nomina.services.durandb.TipoCajasService;

@RestController
@RequestMapping("/tipo-cajas")
public class TipoCajasController {

    @Autowired
    TipoCajasService tipoCajasService;

    @GetMapping()
    public ArrayList<TipoCajasModel> obtenerTipoCajas() {
        return tipoCajasService.obtenerTipoCajas();
    }
}
