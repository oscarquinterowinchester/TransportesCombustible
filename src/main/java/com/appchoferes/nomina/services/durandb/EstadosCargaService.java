package com.appchoferes.nomina.services.durandb;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appchoferes.nomina.models.durandb.EstadosCargaModel;
import com.appchoferes.nomina.repositories.durandb.EstadosCargaRepository;

@Service
public class EstadosCargaService {

    @Autowired
    EstadosCargaRepository estadosCargaRepository;

    public ArrayList<EstadosCargaModel> obtenerEstados() {
        return (ArrayList<EstadosCargaModel>) estadosCargaRepository.findAll();
    }
}
