package com.appchoferes.nomina.services.durandb;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appchoferes.nomina.models.durandb.RutasModel;
import com.appchoferes.nomina.repositories.durandb.RutasRepository;

@Service
public class RutasService {

    @Autowired
    RutasRepository rutasRepository;

    public ArrayList<RutasModel> obtenerRutas() {
        return (ArrayList<RutasModel>) rutasRepository.findAll();
    }

    public ArrayList<RutasModel> obtenerRutasActivas() {
        return (ArrayList<RutasModel>) rutasRepository.findRutasActivas();
    }

    public Optional<RutasModel> findById(int id) {
        return rutasRepository.findById(id);
    }

    public RutasModel registrarRutas(RutasModel ruta) {
        return rutasRepository.save(ruta);
    }
}
