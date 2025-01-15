package com.appchoferes.nomina.services.durandb;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appchoferes.nomina.models.durandb.TipoMovModel;
import com.appchoferes.nomina.repositories.durandb.TipoMovRepository;

@Service
public class TipoMovService {

    @Autowired
    TipoMovRepository tipoMovRepository;

    public ArrayList<TipoMovModel> obtenerTipoMov() {
        return (ArrayList<TipoMovModel>) tipoMovRepository.findAll();
    }
}
