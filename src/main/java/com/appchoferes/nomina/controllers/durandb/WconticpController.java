package com.appchoferes.nomina.controllers.durandb;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.appchoferes.nomina.models.durandb.WconticpModel;
import com.appchoferes.nomina.repositories.durandb.WconticpRepository;
import com.appchoferes.nomina.services.durandb.WconticpService;

@RestController
@RequestMapping("/wconticp")
public class WconticpController {
    @Autowired
    WconticpService wconticpService;

    @Autowired
    WconticpRepository wconticpRepository;

    @GetMapping()
    public ArrayList<WconticpModel> obtenerWcont() {
        return wconticpService.obtenerWcont();
    }

    @GetMapping("/bywcontid/{wcontID}")
    public ResponseEntity<WconticpModel> findByWcontID(@PathVariable Integer wcontID) {
        Optional<WconticpModel> icont = wconticpRepository.findByWcontID(wcontID);

        if (icont.isPresent()) {
            return ResponseEntity.ok(icont.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/status")
    public ArrayList<WconticpModel> getWconticpByStatus(
            @RequestParam(value = "status", defaultValue = "1") int Status) {
        return wconticpRepository.findByStatus(Status);
    }

    @PostMapping()
    public WconticpModel registrarOrden(@RequestBody WconticpModel nuevaOrden) {
        return wconticpService.registrarOrden(nuevaOrden);
    }
@PutMapping("/updatestatusfalse/{id}")
    public ResponseEntity<WconticpModel> actualizarCartasPorteFalse(@PathVariable Integer id){
        WconticpModel wcExistente = wconticpRepository.findByCartaPorteID(id);
        if(wcExistente != null){
            wcExistente.setStatus((byte) 0);
            WconticpModel ordenActualizado = wconticpRepository.save(wcExistente);
            return ResponseEntity.ok(ordenActualizado);
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
