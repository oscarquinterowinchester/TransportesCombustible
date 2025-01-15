package com.appchoferes.nomina.services.durandb;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appchoferes.nomina.models.durandb.TiposChoferesModel;
import com.appchoferes.nomina.repositories.durandb.TiposChoferesRepository;

@Service
public class TiposChoferesService {

    @Autowired
    TiposChoferesRepository tipoChoferesRepository;

    public ArrayList<TiposChoferesModel> obtenerChoferes() {
        return (ArrayList<TiposChoferesModel>) tipoChoferesRepository.findAll();
    }
}
