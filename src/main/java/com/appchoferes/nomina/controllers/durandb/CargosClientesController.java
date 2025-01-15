package com.appchoferes.nomina.controllers.durandb;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.appchoferes.nomina.models.durandb.CargosClientesModel;
import com.appchoferes.nomina.repositories.durandb.CargosClientesRepository;
import com.appchoferes.nomina.services.durandb.CargosClientesService;

@RestController
@RequestMapping("/cargosclientes")
public class CargosClientesController {

    @Autowired
    CargosClientesService cargosClientesService;

    @Autowired
    CargosClientesRepository cargosClientesRepository;

    @GetMapping()
    public ArrayList<CargosClientesModel> obtenerCargos() {
        return cargosClientesService.obtenerCargos();
    }

    @GetMapping("/byWcontId/{wcontID}")
    public ResponseEntity<List<CargosClientesModel>> getByWcontId(@PathVariable Integer wcontID) {
        List<CargosClientesModel> wcont = cargosClientesRepository.findByWContID(wcontID);

        if (!wcont.isEmpty()) {
            return ResponseEntity.ok(wcont);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
