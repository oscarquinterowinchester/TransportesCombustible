package com.appchoferes.nomina.controllers.lorasdb;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @PostMapping("/saveSalidaContenedor")
    public ResponseEntity<Map<String, Object>> saveSalidaContenedor(@RequestBody SalidaContenedorDTO request) {
        Map<String, Object> response = new HashMap<>();

        try {
            Integer idContenedor = salidaContenedorService.saveSalidaContenedor(request.getContenedor(),
                    request.getPuntos());
            response.put("data", true); // Puedes agregar un valor si la inserción fue exitosa
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.put("data", false);
            response.put("message", "Error al guardar el contenedor");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

}