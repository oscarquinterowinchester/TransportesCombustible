package com.appchoferes.nomina.controllers.durandb;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.appchoferes.nomina.models.durandb.ParadasConsultaModel;
import com.appchoferes.nomina.models.durandb.ParadaswcModel;
import com.appchoferes.nomina.repositories.durandb.ParadasConsultaRepository;
import com.appchoferes.nomina.repositories.durandb.ParadaswcRepository;
import com.appchoferes.nomina.services.durandb.ParadaswcService;

@RestController
@RequestMapping("/paradaswc")
public class ParadaswcController {

    @Autowired
    ParadaswcService paradaswcService;

    @Autowired
    ParadaswcRepository paradaswcRepository;

    @Autowired
    ParadasConsultaRepository paradasconsultaRepository;

    @GetMapping()
    public ArrayList<ParadaswcModel> obtenerParada() {
        return paradaswcService.obtenerParada();
    }

    /*@GetMapping("/getall/{WcontID}")
    public ArrayList<ParadaswcModel> obtenerParadas(@PathVariable Integer WcontID) {
        return paradaswcService.getParadas(WcontID);
    }*/

    @GetMapping("/getall/{WcontID}")
    public ArrayList<ParadasConsultaModel> obtenerParadas(@PathVariable Integer WcontID) {
        return paradaswcService.getParadas(WcontID);
    }

    @GetMapping("/getparadawcont/{WcontID}")
    public ArrayList<ParadasConsultaModel> obtenerParadaswcont(@PathVariable Integer WcontID) {
        return paradaswcService.getParadaswcont(WcontID);
    }
    

    @PostMapping()
    public ParadaswcModel registrarParada(
            @RequestBody ParadaswcModel parada) {
        return paradaswcService.registrarParada(parada);
    }

    @DeleteMapping("/deleting/{WcontID}")
    public ResponseEntity<Map<String, String>> deleteParada(@PathVariable Integer WcontID) {
        ArrayList<ParadaswcModel> parada = paradaswcRepository.findParadasbywcontID(WcontID);

        if (parada.size() > 0) {
            paradaswcRepository.deleteAll(parada);
            return ResponseEntity.ok(Map.of("message", "Parada eliminada correctamente"));
        } else {
            return ResponseEntity.ok(Map.of("estado", "0"));
        }
    }

    // @PutMapping("/updateStatus/{wcid}")
    // public ResponseEntity<Void> updateStatusForWcid(@PathVariable String wcid) {
    // paradaswcService.actualizarStatusParaWcid(wcid);
    // return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    // }
}
