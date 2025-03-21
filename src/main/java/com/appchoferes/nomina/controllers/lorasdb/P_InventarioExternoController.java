package com.appchoferes.nomina.controllers.lorasdb;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.appchoferes.nomina.models.lorasdb.InventarioExternoInspeccion;
import com.appchoferes.nomina.models.lorasdb.P_InventarioExterno;
import com.appchoferes.nomina.models.lorasdb.dtos.InventarioExternoEntradaRequest;
import com.appchoferes.nomina.models.lorasdb.dtos.PuntosCTPADSalidaDTO;
import com.appchoferes.nomina.services.lorasdb.InventarioExternoService;
import com.appchoferes.nomina.services.lorasdb.PV_RawQueryService;

@RestController
@RequestMapping("/patios")
public class P_InventarioExternoController {

    @Autowired
    private PV_RawQueryService rawQueryService;

    @Autowired
    private InventarioExternoService inventarioExternoService;

    @GetMapping("/getPuntosCTPADSalida")
    public ResponseEntity<?> getPuntosCTPADSalida(@RequestParam Integer id) {
        List<PuntosCTPADSalidaDTO> result = rawQueryService.getPuntosCTPADSalida(id);
        return ResponseEntity.ok(Map.of("success", true, "data", result));
    }

    @PostMapping("/saveContenedorEntrada")
    public ResponseEntity<?> guardarInventario(@RequestBody InventarioExternoEntradaRequest request) {
        boolean isDuplicado = inventarioExternoService.esEntradaDuplicada(request.getContenedor(),
                request.getItinerarioID());

        if (isDuplicado) {
            Map<String, Object> response = new HashMap<>();
            response.put("_estatus", 409); // Codigo personalizado para advertencia
            response.put("message", "Ya hay una entrada con ese contenedor o itinerario");

            // Mandamos status 200 para que angular no lo detecte como error
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }

        try {
            // Mapear los datos del request a la entidad P_InventarioExterno
            P_InventarioExterno inventario = new P_InventarioExterno();
            inventario.setBotando(request.getBotando());
            inventario.setCarrier(request.getCarrier());
            inventario.setContenedor(request.getContenedor());
            inventario.setEquipmentProvider(request.getEquipmentProvider());
            inventario.setFechaEvento(request.getFechaEvento());
            inventario.setItinerarioID(request.getItinerarioID());
            inventario.setPatioID(request.getPatioID());
            inventario.setSello(request.getSello());
            inventario.setUsuarioEventoID(request.getUsuarioEventoID());
            inventario.setUsuarioID(request.getUsuarioID());
            inventario.setWContenedorID(request.getWContenedorID());
            inventario.setFirmak9(request.getFirmak9());
            inventario.setFotoSello(request.getFotoSello());
            inventario.setFirmaChofer(request.getFirmaChofer());
            inventario.setFirmaGuardia(request.getFirmaGuardia());
            inventario.setNota(request.getNota());
            inventario.setAnteriorID(0);
            inventario.setCamion(request.getCamion());
            inventario.setNombreChofer(request.getNombreChofer());
            inventario.setPlacasChasis(request.getPlacasChasis());
            inventario.setEstadoPlacasMex(request.getEstadomex());
            inventario.setEstadoPlacasUsa(request.getEstadousa());
            inventario.setOrigen(request.getOrigen());

            // Asignar Status como 1
            inventario.setStatus(1);

            // Guardar las inspecciones
            List<InventarioExternoInspeccion> inspecciones = request.getPuntos();

            // Llamar al servicio para guardar el inventario y las inspecciones
            P_InventarioExterno savedInventario = inventarioExternoService.saveInventarioEntrada(inventario, inspecciones);

            // Log de la respuesta
            System.out.println("Inventario guardado con ID: " + savedInventario.getInventarioID());

            return new ResponseEntity<>(savedInventario, HttpStatus.CREATED);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(Map.of("message", "Error interno del servidor"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
