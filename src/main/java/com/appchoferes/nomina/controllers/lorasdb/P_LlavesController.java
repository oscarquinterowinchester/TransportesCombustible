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

import com.appchoferes.nomina.models.lorasdb.dtos.LlaveRequest;
import com.appchoferes.nomina.services.lorasdb.LlaveService;

@RestController
@RequestMapping("/visitantes")
public class P_LlavesController {

    @Autowired
    private LlaveService llaveService;

    @PostMapping("/registarLlave")
    public ResponseEntity<?> registrarLlave(@RequestBody LlaveRequest llaveRequest) {
        try {
            llaveService.registrarLlave(llaveRequest);
            Map<String, Object> response = new HashMap<>();
            response.put("_estatus", 200); // Codigo personalizado para advertencia
            response.put("message", "Llave guardada existosamente");

            // Mandamos status 200 para que angular no lo detecte como error
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al registrar la llave: " + e.getMessage());
        }
    }
}
