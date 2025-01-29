package com.appchoferes.nomina.controllers.lorasdb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appchoferes.nomina.models.lorasdb.InventarioExterno;
import com.appchoferes.nomina.services.lorasdb.InventarioExternoServ;

@RestController
@RequestMapping("/patios")
public class P_InventarioExternoController {
    
    @Autowired
    private InventarioExternoServ invExtServ;

    @PostMapping("/save-contenedorEntrada")
    public ResponseEntity<?> saveContenedorEntrada(@RequestBody InventarioExterno contenedor){
        try {
            Integer inventarioId = invExtServ.procesarInventarioExterno(contenedor);
            return ResponseEntity.ok(inventarioId);

        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e){
            return ResponseEntity.status(500).body("Error interno del servidor");
        }
    }
}
