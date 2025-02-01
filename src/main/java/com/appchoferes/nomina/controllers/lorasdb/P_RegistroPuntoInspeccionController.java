package com.appchoferes.nomina.controllers.lorasdb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appchoferes.nomina.models.lorasdb.dtos.PuntosSemanalProjection;
import com.appchoferes.nomina.services.lorasdb.RegistroPuntoInspeccionServ;

import java.util.List;

@RestController
@RequestMapping("/patios")
public class P_RegistroPuntoInspeccionController {

    @Autowired
    private RegistroPuntoInspeccionServ registroPuntoInspeccionService;

    @GetMapping("/puntos-semanal")
    public ResponseEntity<List<PuntosSemanalProjection>> getListaPuntosGuardadosSemanal() {
        List<PuntosSemanalProjection> puntos = registroPuntoInspeccionService.getListaPuntosGuardadosSemanal();
        return ResponseEntity.ok(puntos);
    }
}