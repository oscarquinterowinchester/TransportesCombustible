package com.appchoferes.nomina.controllers.lorasdb;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appchoferes.nomina.models.lorasdb.dtos.ListaInspeccionRequest;
import com.appchoferes.nomina.services.lorasdb.InspeccionFisicaServ;

@RestController
@RequestMapping("/visitantes")
public class V_InspeccionFisicaController {

    @Autowired
    private InspeccionFisicaServ inspeccionFisicaService;

@PostMapping("/saveListaInspeccion")
public ResponseEntity<?> saveListaInspeccion(@RequestBody ListaInspeccionRequest request) {
    try {
        inspeccionFisicaService.saveListaInspeccion(request);
        
        Map<String, String> response = new HashMap<>();
        response.put("message", "Inspección guardada exitosamente.");
        return ResponseEntity.ok(response);  // Respuesta JSON
        
    } catch (Exception e) {
        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("error", "Error en el servidor: " + e.getMessage());
        return ResponseEntity.status(500).body(errorResponse);
    }
}

    
}
