package com.appchoferes.nomina.services.durandb;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appchoferes.nomina.models.durandb.CargosClientesModel;
import com.appchoferes.nomina.repositories.durandb.CargosClientesRepository;

@Service
public class CargosClientesService {

    @Autowired
    CargosClientesRepository cargosClientesRepository;

    public ArrayList<CargosClientesModel> obtenerCargos() {
        return (ArrayList<CargosClientesModel>) cargosClientesRepository.findAll();
    }

    public Optional<CargosClientesModel> findById(int id) {
        return cargosClientesRepository.findById(id);
    }

    public CargosClientesModel registrarCargos(CargosClientesModel chofer) {
        return cargosClientesRepository.save(chofer);
    }
}
