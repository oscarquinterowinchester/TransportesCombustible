package com.appchoferes.nomina.controllers.durandb;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.appchoferes.nomina.models.durandb.ConceptossatrModel;
import com.appchoferes.nomina.services.durandb.ConceptossatrService;

@RestController
@RequestMapping("/conceptossatr")
public class conceptossatrController {

    @Autowired
    ConceptossatrService conceptossatrService;

    @GetMapping()
    public ArrayList<ConceptossatrModel> obtenerConceptos() {
        return conceptossatrService.obtenerConceptos();
    }

    @GetMapping("/{id}")
    public ConceptossatrModel obtenerConceptoPorId(@PathVariable int id) {
        Optional<ConceptossatrModel> entidad = conceptossatrService.findById(id);
        if (entidad.isPresent()) {
            return entidad.get();
        } else {
            return null;
        }
    }
}
