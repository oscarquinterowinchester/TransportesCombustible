package com.appchoferes.nomina.controllers.lorasdb;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appchoferes.nomina.models.lorasdb.Vehiculo;
import com.appchoferes.nomina.repositories.lorasdb.VehiculoRepo;

@RestController
@RequestMapping("/visitantes")
public class VehiculoController {

    @Autowired
    private VehiculoRepo vehiculoRepo;
    
    @GetMapping("/getAllVehicles")
    public ResponseEntity<List<Vehiculo>> getAllVehicles(){
        return ResponseEntity.ok(vehiculoRepo.findAll());
    }
}
