package com.appchoferes.nomina.services.durandb;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appchoferes.nomina.models.durandb.TipoOperacionModel;
import com.appchoferes.nomina.repositories.durandb.TipoOperacionRepository;

@Service
public class TipoOperacionService {

    @Autowired
    TipoOperacionRepository tipoOperacionRepository;

    public ArrayList<TipoOperacionModel> obtenerTipoOperacion() {
        return (ArrayList<TipoOperacionModel>) tipoOperacionRepository.findAll();
    }
}
