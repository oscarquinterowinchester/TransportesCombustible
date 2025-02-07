package com.appchoferes.nomina.services.lorasdb;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.appchoferes.nomina.models.lorasdb.dtos.BusquedaVisitanteDTO;

@RestController
@RequestMapping("/visitantes")
public class VisitanteController {

    @Autowired
    private VisitanteService visitanteService;

    @GetMapping("/getBusquedaVisitantes")
    public ResponseEntity<List<BusquedaVisitanteDTO>> buscarVisitantes(
        @RequestParam(required = false) String word
    ) {
        List<BusquedaVisitanteDTO> visitantes = visitanteService.buscarVisitantes(word);
        return ResponseEntity.ok(visitantes);
    }
}