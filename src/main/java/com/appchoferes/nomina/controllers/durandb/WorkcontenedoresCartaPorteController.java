package com.appchoferes.nomina.controllers.durandb;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.appchoferes.nomina.models.durandb.WorkcontenedoresCartaPorteModel;
import com.appchoferes.nomina.repositories.durandb.WorkcontenedoresCartaPorteRepository;
import com.appchoferes.nomina.services.durandb.WorkcontenedoresCartaPorteService;

@RestController
@RequestMapping("/workcontenedorCartaPorte")
public class WorkcontenedoresCartaPorteController {

    @Autowired
    WorkcontenedoresCartaPorteService workcontenedoresCartaPorteService;

    @Autowired
    WorkcontenedoresCartaPorteRepository workcontenedoresCartaPorteRepository;

    @GetMapping()
    public ArrayList<WorkcontenedoresCartaPorteModel> obtenerWorkcontenedor() {
        return workcontenedoresCartaPorteService.obtenerWorkcontenedor();
    }

    @GetMapping("/bywcontid/{wcontID}")
    public ResponseEntity<List<WorkcontenedoresCartaPorteModel>> findByWcontID(@PathVariable Integer wcontID) {
        List<WorkcontenedoresCartaPorteModel> icont = workcontenedoresCartaPorteRepository.findByWcontID(wcontID);

        if (!icont.isEmpty()) {
            return ResponseEntity.ok(icont);
        } else {
            return null;
        }
    }

    @PostMapping()
    public WorkcontenedoresCartaPorteModel registrarWorkcontenedorCarta(
            @RequestBody WorkcontenedoresCartaPorteModel workcartap) {
        return workcontenedoresCartaPorteService.registrarWorkcontenedorCarta(workcartap);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> deleteMercancias(@PathVariable Integer id) {
        List<WorkcontenedoresCartaPorteModel> merca = workcontenedoresCartaPorteRepository.findByWcontID(id);

        if (merca.size() > 0) {
            workcontenedoresCartaPorteRepository.deleteAll(merca);
            return ResponseEntity.ok(Map.of("estado", "1"));
        } else {
            return ResponseEntity.ok(Map.of("estado", "0"));
        }
    }

    @PostMapping("/contenedores")
    public String registrarWorkcontenedoresCarta(@RequestBody WorkcontenedoresCartaPorteModel[] workcartap) {
        System.out.println(workcartap);
            /*for (WorkcontenedoresCartaPorteModel workcontenedoresCartaPorteModel : workcartap) {
            }*/
        return  "Guardados Correctamente";
    }
}
