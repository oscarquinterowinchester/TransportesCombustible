package com.appchoferes.nomina.controllers.lorasdb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.appchoferes.nomina.models.lorasdb.dtos.RegistroHistorialDTO;
import com.appchoferes.nomina.models.lorasdb.dtos.RegistroPendientesDTO;
import com.appchoferes.nomina.services.lorasdb.RegistroVisitorServ;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/visitantes")
public class P_RegistroVisitorController {

    @Autowired
    private RegistroVisitorServ registroService;

    @GetMapping("/getRegistrosHistorial")
    public ResponseEntity<List<RegistroHistorialDTO>> getRegistrosHistorial(
            @RequestParam(required = false) Long id,
            @RequestParam(required = false) String inicio,
            @RequestParam(required = false) String finalDate) {
        LocalDateTime inicioDateTime = inicio != null ? LocalDateTime.parse(inicio + "T00:00:00") : null;
        LocalDateTime finalDateTime = finalDate != null ? LocalDateTime.parse(finalDate + "T23:59:59") : null;

        List<RegistroHistorialDTO> registros = registroService.getRegistrosHistorial(id, inicioDateTime, finalDateTime);
        return ResponseEntity.ok(registros);
    }

    @GetMapping("/getRegistrosPendientes")
    public ResponseEntity<List<RegistroPendientesDTO>> getRegistrosPendientes(
            @RequestParam(required = false) Long id,
            @RequestParam(required = false) String inicio,
            @RequestParam(required = false) String finalDate) {
        LocalDateTime inicioDateTime = inicio != null ? LocalDateTime.parse(inicio) : null;
        LocalDateTime finalDateTime = finalDate != null ? LocalDateTime.parse(finalDate) : null;

        List<RegistroPendientesDTO> registros = registroService.getRegistrosPendientes(id, inicioDateTime,
                finalDateTime);
        return ResponseEntity.ok(registros);
    }

}