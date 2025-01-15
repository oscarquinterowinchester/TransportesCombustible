package com.appchoferes.nomina.services.durandb;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appchoferes.nomina.models.durandb.ConceptossatrModel;
import com.appchoferes.nomina.repositories.durandb.ConceptossatrRepository;

@Service
public class ConceptossatrService {

    @Autowired
    ConceptossatrRepository conceptossatrRepository;

    public ArrayList<ConceptossatrModel> obtenerConceptos() {
        return (ArrayList<ConceptossatrModel>) conceptossatrRepository.findAll();
    }

    public Optional<ConceptossatrModel> findById(int id) {
        return conceptossatrRepository.findById(id);
    }
}
