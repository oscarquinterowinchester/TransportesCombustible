package com.appchoferes.nomina.modules.combustible.controllers;

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

import com.appchoferes.nomina.modules.combustible.dtos.CargasDieselDTO;
import com.appchoferes.nomina.modules.combustible.dtos.ComCargaDieselDTO;
import com.appchoferes.nomina.modules.combustible.dtos.HistorialAnteriorDTO;
import com.appchoferes.nomina.modules.combustible.models.CargaDiesel;
import com.appchoferes.nomina.modules.combustible.services.CombustibleCargasDieselService;
import com.appchoferes.nomina.modules.combustible.services.InsertCargaDiesel;

import jakarta.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/api/combustible")
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
    public ResponseEntity<CargaDiesel> insertarCargaDiesel(@RequestBody ComCargaDieselDTO comCargaDieselDTO) {

        try {
            CargaDiesel cargaDiesel = insertCargaDiesel.insertarCargaDiesel(comCargaDieselDTO);

            if (cargaDiesel != null) {
                return ResponseEntity.status(HttpStatus.CREATED).body(cargaDiesel);
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
            }

        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }

}
