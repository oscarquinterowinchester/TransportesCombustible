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
import com.appchoferes.nomina.models.lorasdb.dtos.RegistroFirmaDTO;
import com.appchoferes.nomina.models.lorasdb.dtos.RegistroInicialDTO;
import com.appchoferes.nomina.services.lorasdb.RegistroCorrespondenciaServ;

@RestController
@RequestMapping("/visitantes")
public class V_RegistroCorrespondenciaController {

    @Autowired
    private RegistroCorrespondenciaServ rCserv;

    @GetMapping("/getRegistrosCorrespondenciaPendientes")
    public List<RegistroCorrespondencia> getRegistrosC() {
        return rCserv.getRegistrosC();
    }

    @PostMapping("/saveRegistrosCorrespondencia")
    public ResponseEntity<?> saveRegistro(@RequestBody RegistroInicialDTO registroInicial) {
        try {
            RegistroCorrespondencia registroGuardado = rCserv.saveRegistro(registroInicial);
            return ResponseEntity.ok(Map.of(
                    "message", "Registro insertado con éxito",
                    "registro", registroGuardado));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Map.of("error", "Error al guardar el registro", "message", e.getMessage()));
        }
    }

    @PostMapping("/saveEntregado")
    public ResponseEntity<?> saveEntregado(@RequestBody RegistroFirmaDTO registroFirma) {
        try {
            // Guardar la firma y obtener el registro actualizado
            RegistroCorrespondencia registroActualizado = rCserv.saveFirma(registroFirma);

            // Retornar un objeto JSON con el mensaje y los datos
            return ResponseEntity.ok(Map.of(
                    "message", "Firma y fecha de entrega actualizadas correctamente",
                    "data", registroActualizado));
        } catch (Exception e) {
            // Manejo de errores
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of(
                    "error", "Error al procesar la solicitud",
                    "message", e.getMessage()));
        }
    }

}
