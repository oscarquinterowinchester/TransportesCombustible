package com.appchoferes.nomina.controllers.lorasdb;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.appchoferes.nomina.models.lorasdb.Vehiculo;
import com.appchoferes.nomina.models.lorasdb.dtos.getVehiculoDTO;
import com.appchoferes.nomina.repositories.lorasdb.VehiculoRepo;
import com.appchoferes.nomina.services.lorasdb.VehiculoServ;

@RestController
@RequestMapping("/visitantes")
public class V_VehiculoController {

    @Autowired
    private VehiculoRepo vehiculoRepo;

    @Autowired
    private VehiculoServ vehiculoServ;
    
    @GetMapping("/getAllVehicles")
    public ResponseEntity<List<Vehiculo>> getAllVehicles(){
        return ResponseEntity.ok(vehiculoRepo.findAll());
    }

    @GetMapping("/getMisVehiculos")
    public ResponseEntity<List<getVehiculoDTO>> getMistVehiculos(@RequestParam Integer id){
        return ResponseEntity.ok(vehiculoServ.getMisVehiculos(id));
    }
}
