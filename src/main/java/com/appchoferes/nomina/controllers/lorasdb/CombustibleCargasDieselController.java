package com.appchoferes.nomina.controllers.lorasdb;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.appchoferes.nomina.models.lorasdb.CargaDiesel;
import com.appchoferes.nomina.models.lorasdb.dtos.CargasDieselDTO;
import com.appchoferes.nomina.models.lorasdb.dtos.HistorialAnteriorDTO;
import com.appchoferes.nomina.services.lorasdb.CombustibleCargasDieselService;
import com.appchoferes.nomina.services.lorasdb.InsertCargaDiesel;

import jakarta.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/combustible")
public class CombustibleCargasDieselController {

    @Autowired
    private CombustibleCargasDieselService combustibleCargasDieselService;

    @Autowired
    private InsertCargaDiesel insertCargaDiesel;

    @GetMapping("/historial-cargas")
    public List<CargasDieselDTO> getHistorial(
            @RequestParam("id") Long id,
            @RequestParam("tipo") Integer tipo) {
        return combustibleCargasDieselService.getHistorialCargas(id, tipo);
    }

    @GetMapping("/historial-anterior")
    public List<HistorialAnteriorDTO> getHistorialAnterior(
            @RequestParam("id") Long id,
            @RequestParam("fechaActual") String fechaActual) {
        return combustibleCargasDieselService.getHistorialAnterior(id, fechaActual);
    }

    @PostMapping("/insertar")
    public ResponseEntity<?> insertarCargaDiesel(@RequestBody CargaDiesel cargaDiesel) {

        try {
            System.out.println("Datos recibidos en el controlador: " + cargaDiesel);

            // Llamada al servicio
            insertCargaDiesel.insertarCargaDiesel(cargaDiesel);

            //System.out.println("CargaDiesel devuelta por el servicio: " + cargaDiesel);

            if (cargaDiesel != null) {
                return ResponseEntity.status(HttpStatus.CREATED).body(cargaDiesel);
            } else {
                System.out.println("El servicio devolvió un valor nulo");
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
            }

        } catch (EntityNotFoundException e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(null);
        } catch (Exception e) {
            System.err.println("Excepción no manejada: " + e.getMessage());
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }

}
