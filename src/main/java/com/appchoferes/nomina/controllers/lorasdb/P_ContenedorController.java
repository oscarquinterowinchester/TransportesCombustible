package com.appchoferes.nomina.controllers.lorasdb;

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

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/patios")
public class P_ContenedorController {

    @Autowired
    private ContenedorPatioServ service;

    @GetMapping("/contenedores-patio")
    public Map<String, Object> getContenedores(@RequestParam int patioId, @RequestParam int usuarioId) {
        return service.obtenerContenedores(patioId, usuarioId);
    }

    @GetMapping("/entrada")
    public Object getContenedorEntrada(
            @RequestParam(required = false) Long itinerarioId,
            @RequestParam(required = false) String contenedor,
            @RequestParam Integer tipo) {

        return service.getContenedorEntrada(itinerarioId, contenedor, tipo);
    }

    @GetMapping("/getContenedorPatio")
    public ResponseEntity<?> buscarContenedor(
            @RequestParam(required = false) Integer itinerarioId,
            @RequestParam(required = false) String contenedor,
            @RequestParam int tipo) {

        // Validación de datos
        if ((itinerarioId == null && tipo == 2) || (contenedor == null && tipo == 1)) {
            return ResponseEntity.badRequest().body("Datos inválidos");
        }

        if (tipo == 1) {
            // Lógica para tipo 1
            List<ContenedorTipo1DTO> entradas = service.getEntradasByContenedor(contenedor);
            if (entradas.isEmpty()) {
                return ResponseEntity.ok("No se encontraron entradas para el contenedor: " + contenedor);
            }

            return ResponseEntity.ok(entradas);
        } else if (tipo == 2) {
            // Lógica para tipo 2
            if (itinerarioId == null) {
                return ResponseEntity.badRequest().body("ItinerarioID es requerido para el tipo 2");
            }

            // Obtener la entrada
            List<ContenedorTipo2DTO> entradas = service.getEntradaByItinerarioID(itinerarioId);
            if (entradas.isEmpty()) {
                return ResponseEntity.ok("No se encontró una entrada para el itinerario: " + itinerarioId);
            }

            int inventarioID = entradas.get(0).getInventarioID();

            // Verificar si hay una salida
            List<P_InventarioExterno> salidas = service.getSalidaByAnteriorID(inventarioID);
            if (!salidas.isEmpty()) {
                return ResponseEntity.ok("No se encontraron datos para el itinerario: " + itinerarioId);
            }

            // Obtener los datos del contenedor
            List<Object[]> contenedorData = service.getContenedorByItinerarioID(itinerarioId, inventarioID);
            if (contenedorData.isEmpty()) {
                return ResponseEntity.ok("No se encontraron datos para el itinerario: " + itinerarioId);
            }

            return ResponseEntity.ok(contenedorData);
        } else {
            return ResponseEntity.badRequest().body("Tipo inválido");
        }
    }
}