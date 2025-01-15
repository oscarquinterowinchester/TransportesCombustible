package com.appchoferes.nomina.services.durandb;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appchoferes.nomina.models.durandb.ChoferesModel;
import com.appchoferes.nomina.repositories.durandb.ChoferesRepository;

@Service
public class ChoferesService {
    @Autowired
    ChoferesRepository choferesRepository;

    public ArrayList<ChoferesModel> obtenerChoferes() {
        return (ArrayList<ChoferesModel>) choferesRepository.findAll();
    }

    public ChoferesModel registrarChofer(ChoferesModel chofer) {
        return choferesRepository.save(chofer);
    }
}
