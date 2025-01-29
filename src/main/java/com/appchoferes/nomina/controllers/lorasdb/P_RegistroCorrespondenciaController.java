package com.appchoferes.nomina.controllers.lorasdb;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appchoferes.nomina.models.lorasdb.RegistroCorrespondencia;
import com.appchoferes.nomina.services.lorasdb.RegistroCorrespondenciaServ;

@RestController
@RequestMapping("/patios")
public class P_RegistroCorrespondenciaController {

    @Autowired
    private RegistroCorrespondenciaServ rCserv;

    @GetMapping("/registros-correspondencia")
    public List<RegistroCorrespondencia> getRegistrosC() {
        return rCserv.getRegistrosC();
    }

    @PostMapping("/save-registroCorrespencia")
    public ResponseEntity<?> saveRegistro(@RequestBody RegistroCorrespondencia registro) {
        try {
            // Guardar el registro en la base de datos
            RegistroCorrespondencia registroGuardado = rCserv.saveRegistro(registro);

            // Retornar el registro guardado
            return ResponseEntity.ok(Map.of(
                "message", "Registro insertado con éxito",
                "registro", registroGuardado
            ));

        } catch (Exception e) {
            // Manejo de errores
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Map.of("error", "Error al guardar el registro", "message", e.getMessage()));
        }
    }

    @PostMapping("/save-entregado")
    public ResponseEntity<?> saveEntregado(@RequestBody RegistroCorrespondencia registro) {
        try {
            String mensaje = rCserv.saveFirma(registro);
            return ResponseEntity.ok(mensaje);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al procesar la solicitud");
        }
    }

}
