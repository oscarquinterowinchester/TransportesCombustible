package com.appchoferes.nomina.controllers.lorasdb;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appchoferes.nomina.models.lorasdb.ListadoInspeccion;
import com.appchoferes.nomina.services.lorasdb.ListadoInspServ;

@RestController
@RequestMapping("/patios")
public class P_ListadoInspeccionController {

    @Autowired
    private ListadoInspServ listadoInspServ;

    @GetMapping("/listado-inspeccion/{itinerarioID}")
    public List<ListadoInspeccion> getListadoInspeccion(@PathVariable int itinerarioID) {
        return listadoInspServ.getListadoInspeccion(itinerarioID);
    }
}
