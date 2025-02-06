package com.appchoferes.nomina.controllers.lorasdb;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.appchoferes.nomina.models.lorasdb.ListadoInspeccion;
import com.appchoferes.nomina.services.lorasdb.ListadoInspServ;

@RestController
@RequestMapping("/patios")
public class P_ListadoInspeccionController {

    @Autowired
    private ListadoInspServ listadoInspServ;

    @GetMapping("/getPuntosCTPAD")
    public List<ListadoInspeccion> getListadoInspeccion(@RequestParam(required = false) Integer itinerarioID) {
        // Verifica si itinerarioID es null, si es así, pasa null a tu servicio
        return listadoInspServ.getListadoInspeccion(itinerarioID);
    }
}
