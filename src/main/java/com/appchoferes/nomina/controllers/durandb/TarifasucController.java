package com.appchoferes.nomina.controllers.durandb;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.appchoferes.nomina.models.durandb.TarifasucModel;
import com.appchoferes.nomina.repositories.durandb.TarifasucRepository;
import com.appchoferes.nomina.services.durandb.TarifasucService;

@RestController
@RequestMapping("/tarifasuc")
public class TarifasucController {

    @Autowired
    TarifasucService tarifasucService;

    @Autowired
    TarifasucRepository tarifasucRepository;

    @GetMapping()
    public ArrayList<TarifasucModel> obtenerTarifasuc() {
        return tarifasucService.obtenerTarifasuc();
    }

    @GetMapping("/byrutafk/{tarifa}")
    public ResponseEntity<List<TarifasucModel>> findByRutafk(@PathVariable Integer tarifa) {
        List<TarifasucModel> ruta = tarifasucRepository.findByRutafk(tarifa);

        if (!ruta.isEmpty()) {
            return ResponseEntity.ok(ruta);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping()
    public TarifasucModel registrarTarifasuc(@RequestBody TarifasucModel nuevaTarifa) {
        return tarifasucService.registrarTarifasuc(nuevaTarifa);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> deleteCamion(@PathVariable Integer id) {
        Optional<TarifasucModel> tarifa = tarifasucRepository.findById(id);

        if (tarifa.isPresent()) {
            tarifasucRepository.deleteById(id);
            return ResponseEntity.ok(Map.of("message", "Tarifa eliminada correctamente"));
        } else {
            return ResponseEntity.notFound().build(); // El camión no se encontró
        }
    }
}
