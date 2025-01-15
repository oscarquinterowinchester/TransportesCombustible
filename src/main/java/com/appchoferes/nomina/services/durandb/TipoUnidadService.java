package com.appchoferes.nomina.services.durandb;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appchoferes.nomina.models.durandb.TipoUnidadModel;
import com.appchoferes.nomina.repositories.durandb.TipoUnidadRepository;

@Service
public class TipoUnidadService {

    @Autowired
    TipoUnidadRepository tipoUnidadRepository;

    public ArrayList<TipoUnidadModel> obtenerTipoUnidad() {
        return (ArrayList<TipoUnidadModel>) tipoUnidadRepository.findAll();
    }

}
