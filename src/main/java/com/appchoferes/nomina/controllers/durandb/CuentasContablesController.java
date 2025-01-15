package com.appchoferes.nomina.controllers.durandb;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.appchoferes.nomina.models.durandb.CuentasContablesModel;
import com.appchoferes.nomina.services.durandb.CuentasContablesService;

@RestController
@RequestMapping("/cuentascontables")
public class CuentasContablesController {
    @Autowired
    CuentasContablesService cuentasContablesService;

    @GetMapping()
    public ArrayList<CuentasContablesModel> obtenerCuentas() {
        return cuentasContablesService.obtenerCuentas();
    }
}
