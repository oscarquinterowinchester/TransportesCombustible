package com.appchoferes.nomina.services.durandb;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appchoferes.nomina.models.durandb.PaisesModel;
import com.appchoferes.nomina.repositories.durandb.PaisesRepository;

@Service
public class PaisesService {

    @Autowired
    PaisesRepository paisesRepository;

    public ArrayList<PaisesModel> obtenerPaises() {
        return (ArrayList<PaisesModel>) paisesRepository.findAll();
    }
}
