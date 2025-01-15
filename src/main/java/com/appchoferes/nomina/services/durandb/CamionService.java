package com.appchoferes.nomina.services.durandb;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appchoferes.nomina.models.durandb.CamionModel;
import com.appchoferes.nomina.repositories.durandb.CamionRepository;

@Service
public class CamionService {

    @Autowired
    CamionRepository camionRepository;

    public ArrayList<CamionModel> obtenerCamiones() {
        ArrayList<CamionModel> camiones = (ArrayList<CamionModel>) camionRepository.findAll();
        return camiones;
    }

    public ArrayList<CamionModel> obtenerCamionesActivos() { return camionRepository.findCamionesActivos();}

    public Optional<CamionModel> findById(int id) {
        return camionRepository.findById(id);
    }

    public CamionModel registrarCamion(CamionModel camion) {
        return camionRepository.save(camion);
    }

}
