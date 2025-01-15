package com.appchoferes.nomina.services.durandb;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appchoferes.nomina.models.durandb.EstadosModel;
import com.appchoferes.nomina.repositories.durandb.EstadosRepository;

@Service
public class EstadosService {

    @Autowired
    EstadosRepository estadosRepository;

    public ArrayList<EstadosModel> obtenerEstados() {
        return (ArrayList<EstadosModel>) estadosRepository.findAll();
    }
}
