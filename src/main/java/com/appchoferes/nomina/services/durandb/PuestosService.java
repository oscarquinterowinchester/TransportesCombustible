package com.appchoferes.nomina.services.durandb;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appchoferes.nomina.models.durandb.PuestosModel;
import com.appchoferes.nomina.repositories.durandb.PuestosRepository;

@Service
public class PuestosService {

    @Autowired
    PuestosRepository puestosRepository;

    public ArrayList<PuestosModel> obtenerPuestos() {
        return (ArrayList<PuestosModel>) puestosRepository.findAll();
    }
}
