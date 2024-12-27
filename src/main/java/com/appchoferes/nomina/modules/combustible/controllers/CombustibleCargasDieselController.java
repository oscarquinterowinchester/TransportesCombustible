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
import com.appchoferes.nomina.modules.combustible.services.CombustibleCargasDieselService;
import com.appchoferes.nomina.modules.combustible.services.InsertCargaDiesel;

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
    public ResponseEntity<String> insertarCargaDiesel(@RequestBody ComCargaDieselDTO comCargaDieselDTO) {

        try {
            insertCargaDiesel.insertarCargaDiesel(comCargaDieselDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body("carga disel insertada correctamente");

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("error al insertar la carga: " + e.getMessage());
        }
    }

}
