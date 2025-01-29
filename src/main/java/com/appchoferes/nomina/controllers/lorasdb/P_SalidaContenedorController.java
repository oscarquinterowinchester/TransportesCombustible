package com.appchoferes.nomina.controllers.lorasdb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appchoferes.nomina.models.lorasdb.dtos.SalidaContenedorDTO;
import com.appchoferes.nomina.services.lorasdb.SalidaContenedorServ;

@RestController
@RequestMapping("/patios")
public class P_SalidaContenedorController {

    @Autowired
    private SalidaContenedorServ salidaContenedorService;

    @PostMapping("/salida-contenedor")
    public ResponseEntity<?> saveSalidaContenedor(@RequestBody SalidaContenedorDTO salidaContenedorDTO) {
        try {
            salidaContenedorService.procesarSalidaContenedor(salidaContenedorDTO);
            return ResponseEntity.ok("La salida del contenedor y los puntos se registraron correctamente.");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error al procesar la salida del contenedor.");
        }
    }
}