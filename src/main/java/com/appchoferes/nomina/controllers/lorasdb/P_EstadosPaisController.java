package com.appchoferes.nomina.controllers.lorasdb;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appchoferes.nomina.models.lorasdb.EstadosPais;
import com.appchoferes.nomina.services.lorasdb.EstadosPaisServ;

@RestController
@RequestMapping("/patios")
public class P_EstadosPaisController {

    @Autowired
    private EstadosPaisServ estadosPaisServ;

    @GetMapping("/estados/{paisID}")
    public List<EstadosPais> getEstados(@PathVariable Integer paisID) {
        return estadosPaisServ.getEstadosPorPais(paisID);
    }
}
