package com.appchoferes.nomina.services.durandb;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appchoferes.nomina.models.durandb.TipoCajasModel;
import com.appchoferes.nomina.repositories.durandb.TipoCajasRepository;

@Service
public class TipoCajasService {

    @Autowired
    TipoCajasRepository tipoCajasRepository;

    public ArrayList<TipoCajasModel> obtenerTipoCajas() {
        return (ArrayList<TipoCajasModel>) tipoCajasRepository.findAll();
    }
}
