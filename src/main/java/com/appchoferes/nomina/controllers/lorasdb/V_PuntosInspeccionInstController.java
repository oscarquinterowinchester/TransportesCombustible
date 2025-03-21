package com.appchoferes.nomina.controllers.lorasdb;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appchoferes.nomina.models.lorasdb.PuntosInspeccionInstalaciones;
import com.appchoferes.nomina.services.lorasdb.PuntosInspeccionInstServ;

@RestController
@RequestMapping("/visitantes")
public class V_PuntosInspeccionInstController {

    @Autowired
    private PuntosInspeccionInstServ piiServ;

    @GetMapping("/getListaPuntosInspeccion")
    public List<PuntosInspeccionInstalaciones> getPuntosInspeccionInstalaciones() {
        return piiServ.getPuntosInspeccionInstalaciones();
    }

}
