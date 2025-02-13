package com.appchoferes.nomina.controllers.lorasdb;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.appchoferes.nomina.models.lorasdb.dtos.ContenedorEntradaDTO;
import com.appchoferes.nomina.models.lorasdb.dtos.PuntosCTPADSalidaDTO;
import com.appchoferes.nomina.services.lorasdb.InventarioExternoServ;
import com.appchoferes.nomina.services.lorasdb.PV_RawQueryService;

@RestController
@RequestMapping("/patios")
public class P_InventarioExternoController {

    @Autowired
    private InventarioExternoServ invExtServ;

    @Autowired
    private PV_RawQueryService rawQueryService;

    @PostMapping("/saveContenedorEntrada")
    public ResponseEntity<Map<String, Object>> saveContenedorEntrada(@RequestBody ContenedorEntradaDTO contenedor) {
        try {
            invExtServ.procesarInventarioExterno(contenedor);

            // ✅ Respuesta en formato JSON
            Map<String, Object> response = Map.of(
                    "status", "success",
                    "message", "Contenedor insertado correctamente");

            return ResponseEntity.ok().body(response);

        } catch (Exception e) {
            // ✅ Devolver error en JSON
            Map<String, Object> errorResponse = Map.of(
                    "status", "error",
                    "message", e.getMessage());
            return ResponseEntity.status(500).body(errorResponse);
        }
    }

    @GetMapping("/getPuntosCTPADSalida")
    public ResponseEntity<?> getPuntosCTPADSalida(@RequestParam Integer id) {
        List<PuntosCTPADSalidaDTO> result = rawQueryService.getPuntosCTPADSalida(id);
        return ResponseEntity.ok(Map.of("success", true, "data", result));
    }

}
