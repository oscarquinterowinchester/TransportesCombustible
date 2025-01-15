package com.appchoferes.nomina.controllers.durandb;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.appchoferes.nomina.models.durandb.OperadoricpModel;
import com.appchoferes.nomina.repositories.durandb.OperadoricpRepository;
import com.appchoferes.nomina.services.durandb.OperadoricpService;

@RestController
@RequestMapping("/operadoricp")
public class OperadoricpController {

    @Autowired
    OperadoricpService operadoricpService;

    @Autowired
    OperadoricpRepository operadoricpRepository;

    @GetMapping()
    public ArrayList<OperadoricpModel> obtenerOperador() {
        return operadoricpService.obtenerOperador();
    }

    @GetMapping("/byicartaid/{icartid}")
    public ResponseEntity<Optional<OperadoricpModel>> findByICartaID(@PathVariable Integer icartid) {
        Optional<OperadoricpModel> icont = operadoricpRepository.findByICartaID(icartid);

        if (!icont.isEmpty()) {
            return ResponseEntity.ok(icont);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping()
    public OperadoricpModel registrarOperador(@RequestBody OperadoricpModel nuevoOperador) {
        return operadoricpService.registrarOperador(nuevoOperador);
    }
}
