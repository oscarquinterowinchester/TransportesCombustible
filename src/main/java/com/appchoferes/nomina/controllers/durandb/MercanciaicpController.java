package com.appchoferes.nomina.controllers.durandb;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.appchoferes.nomina.models.durandb.MercanciaicpModel;
import com.appchoferes.nomina.repositories.durandb.MercanciasicpRepository;
import com.appchoferes.nomina.services.durandb.MercanciaicpService;

@RestController
@RequestMapping("/mercanciaicp")
public class MercanciaicpController {

    @Autowired
    MercanciaicpService mercanciaicpService;

    @Autowired
    MercanciasicpRepository mercanciasicpRepository;

    @GetMapping()
    public ArrayList<MercanciaicpModel> obtenerMercanciaicp() {
        return mercanciaicpService.obtenerMercanciaicp();
    }

    @GetMapping("/byicartaid/{icartid}")
    public ResponseEntity<List<MercanciaicpModel>> findByICartaID(@PathVariable Integer icartid) {
        List<MercanciaicpModel> icont = mercanciasicpRepository.findByICartaID(icartid);

        if (!icont.isEmpty()) {
            return ResponseEntity.ok(icont);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping()
    public MercanciaicpModel registrarMercancia(@RequestBody MercanciaicpModel nuevaMercancia) {
        return mercanciaicpService.registrarMercancia(nuevaMercancia);
    }
}
