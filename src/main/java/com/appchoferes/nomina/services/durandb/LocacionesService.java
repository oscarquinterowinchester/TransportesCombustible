package com.appchoferes.nomina.services.durandb;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appchoferes.nomina.models.durandb.LocacionesModel;
import com.appchoferes.nomina.repositories.durandb.LocacionesRepository;

@Service
public class LocacionesService {

    @Autowired
    LocacionesRepository locacionesRepository;

    public ArrayList<LocacionesModel> obtenerLocaciones() {
        return (ArrayList<LocacionesModel>) locacionesRepository.findAll();
    }

    public Optional<LocacionesModel> findById(int id) {
        return locacionesRepository.findById(id);
    }

    public LocacionesModel registrarLocaciones(LocacionesModel locacion) {
        return locacionesRepository.save(locacion);
    }

}
