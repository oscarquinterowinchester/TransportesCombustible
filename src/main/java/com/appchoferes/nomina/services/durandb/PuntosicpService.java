package com.appchoferes.nomina.services.durandb;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appchoferes.nomina.models.durandb.PuntosicpModel;
import com.appchoferes.nomina.repositories.durandb.PuntosicpRepository;


@Service
public class PuntosicpService {

    @Autowired
    PuntosicpRepository puntosicpRepository;

    public ArrayList<PuntosicpModel> obtenerPuntos() {
        return (ArrayList<PuntosicpModel>) puntosicpRepository.findAll();
    }

    public PuntosicpModel registrarPuntos(PuntosicpModel puntos) {
        System.out.println(puntos);
        return puntosicpRepository.save(puntos);
    }
}
