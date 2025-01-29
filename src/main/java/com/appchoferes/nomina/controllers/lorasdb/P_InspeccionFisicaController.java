package com.appchoferes.nomina.controllers.lorasdb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appchoferes.nomina.models.lorasdb.dtos.ListaInspeccionRequest;
import com.appchoferes.nomina.services.lorasdb.InspeccionFisicaServ;

@RestController
@RequestMapping("/patios")
public class P_InspeccionFisicaController {

    @Autowired
    private InspeccionFisicaServ inspeccionFisicaService;

    @PostMapping("/save-listaInspeccion")
    public ResponseEntity<?> saveListaInspeccion(@RequestBody ListaInspeccionRequest request) {
        try {
            inspeccionFisicaService.saveListaInspeccion(request);
            return ResponseEntity.ok("Inspección guardada exitosamente.");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error en el servidor: " + e.getMessage());
        }
    }
}
