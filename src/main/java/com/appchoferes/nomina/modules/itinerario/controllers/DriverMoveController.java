package com.appchoferes.nomina.modules.itinerario.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.appchoferes.nomina.modules.itinerario.models.Itinerario;
import com.appchoferes.nomina.modules.itinerario.services.IDriverMoveService;

@RestController
@RequestMapping("/api/itinerario")
public class DriverMoveController {
    
    @Autowired
    IDriverMoveService driverMoveService;


    @GetMapping("")
    public ResponseEntity<?> getItinerariosChofer(@RequestParam String choferId,@RequestParam String dbType)
    {
           
       Itinerario itinerarios = driverMoveService.getItinerario(choferId,dbType);

        return ResponseEntity.ok(itinerarios);
    }
    
    @GetMapping("/visto")
    public ResponseEntity<?> setItinerarioAsVisto(@RequestParam String id,@RequestParam String dbType)
    {
       int estatus = driverMoveService.setItinerarioAsVisto(id,dbType);

        return ResponseEntity.ok(estatus);
    }

}
