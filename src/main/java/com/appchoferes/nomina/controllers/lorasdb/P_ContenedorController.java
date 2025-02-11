package com.appchoferes.nomina.controllers.lorasdb;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.appchoferes.nomina.models.lorasdb.P_InventarioExterno;
import com.appchoferes.nomina.models.lorasdb.dtos.ContenedorTipo1DTO;
import com.appchoferes.nomina.models.lorasdb.dtos.ContenedorTipo2DTO;
import com.appchoferes.nomina.services.lorasdb.ContenedorPatioServ;

@RestController
@RequestMapping("/patios")
public class P_ContenedorController {

    @Autowired
    private ContenedorPatioServ service;

    @GetMapping("/getContenedoresPatio")
    public Map<String, Object> getContenedores(@RequestParam int patioId, @RequestParam int usuarioId) {
        return service.obtenerContenedores(patioId, usuarioId);
    }

    @GetMapping("/getContenedorEntrada")
    public Object getContenedorEntrada(
            @RequestParam(required = false) Long itinerarioId,
            @RequestParam(required = false) String contenedor,
            @RequestParam Integer tipo) {

        return service.getContenedorEntrada(itinerarioId, contenedor, tipo);
    }

    @GetMapping("/getContenedorPatio")
    public ResponseEntity<?> buscarContenedor(
            @RequestParam(required = false) Integer patioID,
            @RequestParam(required = false) String contenedor,
            @RequestParam int tipo) {

        Map<String, Object> response = new HashMap<>();

        // Validación de datos
        if ((patioID == null && tipo == 2) || (contenedor == null && tipo == 1)) {
            response.put("success", false);
            response.put("message", "Datos inválidos");
            return ResponseEntity.badRequest().body(response);
        }

        if (tipo == 1) {
            // Lógica para tipo 1
            List<ContenedorTipo1DTO> entradas = service.getEntradasByContenedor(contenedor);
            if (entradas.isEmpty()) {
                response.put("success", false);
                response.put("message", "No se encontraron entradas para el contenedor: " + contenedor);
                response.put("data", Collections.emptyList());
                return ResponseEntity.ok(response);
            }

            response.put("success", true);
            response.put("data", entradas);
            return ResponseEntity.ok(response);

        } else if (tipo == 2) {
            // Lógica para tipo 2
            if (patioID == null) {
                response.put("success", false);
                response.put("message", "ItinerarioID es requerido para el tipo 2");
                return ResponseEntity.badRequest().body(response);
            }

            List<ContenedorTipo2DTO> entradas = service.getEntradaByItinerarioID(patioID);
            if (entradas.isEmpty()) {
                response.put("success", false);
                response.put("message", "No se encontró una entrada para el itinerario: " + patioID);
                response.put("data", Collections.emptyList());
                return ResponseEntity.ok(response);
            }

            int inventarioID = entradas.get(0).getInventarioID();

            List<P_InventarioExterno> salidas = service.getSalidaByAnteriorID(inventarioID);
            if (!salidas.isEmpty()) {
                response.put("success", false);
                response.put("message", "No se encontraron datos para el itinerario: " + patioID);
                response.put("data", Collections.emptyList());
                return ResponseEntity.ok(response);
            }

            List<Object[]> contenedorData = service.getContenedorByItinerarioID(patioID, inventarioID);
            if (contenedorData.isEmpty()) {
                response.put("success", false);
                response.put("message", "No se encontraron datos para el itinerario: " + patioID);
                response.put("data", Collections.emptyList());
                return ResponseEntity.ok(response);
            }

            response.put("success", true);
            response.put("data", contenedorData);
            return ResponseEntity.ok(response);
        } else {
            response.put("success", false);
            response.put("message", "Tipo inválido");
            return ResponseEntity.badRequest().body(response);
        }
    }

}
