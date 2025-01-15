package com.appchoferes.nomina.services.durandb;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appchoferes.nomina.models.durandb.TamañoModel;
import com.appchoferes.nomina.repositories.durandb.TamañoRepository;

@Service
public class TamañoService {

    @Autowired
    TamañoRepository tamañoRepository;

    public ArrayList<TamañoModel> obtenerTamaño() {
        return (ArrayList<TamañoModel>) tamañoRepository.findAll();
    }

}
