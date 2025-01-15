package com.appchoferes.nomina.controllers.durandb;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appchoferes.nomina.models.durandb.EstadosModel;
import com.appchoferes.nomina.repositories.durandb.EstadosRepository;
import com.appchoferes.nomina.services.durandb.EstadosService;

@RestController
@RequestMapping("/estados")
public class EstadosController {
    

    @Autowired
    EstadosService estadosService;
    @Autowired
    EstadosRepository estadosRepository;

    @GetMapping()
    public ArrayList<EstadosModel> obtenerEstados() {
        return estadosService.obtenerEstados();
    }

    @GetMapping("/bypaisid/{paisid}")
    public ResponseEntity<List<EstadosModel>> findByPaisID(@PathVariable Integer paisid) {
        List<EstadosModel> icont = estadosRepository.findByPaisID(paisid);

        if (!icont.isEmpty()) {
            return ResponseEntity.ok(icont);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
