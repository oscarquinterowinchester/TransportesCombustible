package com.appchoferes.nomina.services.durandb;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appchoferes.nomina.models.durandb.TiposUnidadModel;
import com.appchoferes.nomina.repositories.durandb.TiposUnidadRepository;

@Service
public class TiposUnidadService {

    @Autowired
    TiposUnidadRepository tiposUnidadRepository;

    public ArrayList<TiposUnidadModel> obtenerTiposUnidad() {
        return (ArrayList<TiposUnidadModel>) tiposUnidadRepository.findAll();
    }
}
