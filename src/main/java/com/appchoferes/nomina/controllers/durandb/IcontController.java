package com.appchoferes.nomina.controllers.durandb;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.appchoferes.nomina.models.durandb.IcontModel;
import com.appchoferes.nomina.repositories.durandb.IcontRepository;
import com.appchoferes.nomina.services.durandb.IcontService;

@RestController
@RequestMapping("/icont")
public class IcontController {

    @Autowired
    IcontService icontService;

    @Autowired
    IcontRepository icontRepository;

    @GetMapping()
    public ArrayList<IcontModel> obtenerIcont() {
        return icontService.obtenerIcont();
    }

    @GetMapping("/byItinerariosId/{itinerarioID}")
    public ResponseEntity<IcontModel> getByItinerariosId(@PathVariable Integer itinerarioID) {
        Optional<IcontModel> icont = icontRepository.findByItinerarioID(itinerarioID);

        if (icont.isPresent()) {
            return ResponseEntity.ok(icont.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping()
    public IcontModel saveIcont(@RequestBody IcontModel icont){
        return icontRepository.save(icont);
    }

}
