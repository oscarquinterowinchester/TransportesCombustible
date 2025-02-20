package com.appchoferes.nomina.controllers.lorasdb;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appchoferes.nomina.models.lorasdb.InventarioExternoInspeccion;
import com.appchoferes.nomina.models.lorasdb.P_InventarioExterno;
import com.appchoferes.nomina.models.lorasdb.dtos.InventarioExternoSalidaRequest;
import com.appchoferes.nomina.services.lorasdb.SalidaContenedorServ;

@RestController
@RequestMapping("/patios")
public class P_SalidaContenedorController {

    @Autowired
    private SalidaContenedorServ salidaContenedorService;

    @PostMapping("/saveSalidaContenedor")
    public ResponseEntity<?> saveSalidaContenedor(@RequestBody InventarioExternoSalidaRequest request) {
        try {
            P_InventarioExterno inventario = new P_InventarioExterno();
            inventario.setItinerarioID(request.getItinerarioID());
            inventario.setAnteriorID(request.getInventarioID());
            inventario.setContenedor(request.getContenedor());
            inventario.setPlacasChasis(request.getPlacasChasis());
            inventario.setSello(request.getSello());
            inventario.setChoferID(request.getChoferID());
            inventario.setClienteID(request.getClienteID());
            inventario.setNombreChofer(request.getNombreChofer());
            inventario
                    .setFechaEvento(request.getFechaEvento() != null ? request.getFechaEvento() : LocalDateTime.now());
            inventario.setCamion(request.getCamion());
            inventario.setFirmak9(request.getFirmak9());
            inventario.setOrigen(request.getOrigen());
            inventario.setCarrier(request.getCarrier());
            inventario.setTamano(request.getTamano());

            // Asegurar que otras fechas tengan valores válidos
            inventario
                    .setFechaEvento(request.getFechaEvento() != null ? request.getFechaEvento() : LocalDateTime.now());
            inventario.setFecha(LocalDateTime.now());
            inventario.setFechaElimina(null);
            inventario.setFechaedicion(LocalDateTime.now());

            inventario.setStatus(1);
 
            // Obtiene el arreglo de puntos de inspección
            List<InventarioExternoInspeccion> inspecciones = request.getPuntos();

            P_InventarioExterno savedSalida = salidaContenedorService.saveSalidaInventario(inventario, inspecciones);

            System.out.println("Salida guardada con inventarioID: " + savedSalida.getInventarioID());
            return new ResponseEntity<>(savedSalida, HttpStatus.CREATED);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(Map.of("message", "Error interno del servidor"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}