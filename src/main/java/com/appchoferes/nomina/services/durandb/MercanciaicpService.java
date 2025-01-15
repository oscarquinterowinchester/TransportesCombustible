package com.appchoferes.nomina.services.durandb;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appchoferes.nomina.models.durandb.MercanciaicpModel;
import com.appchoferes.nomina.repositories.durandb.MercanciasicpRepository;

@Service
public class MercanciaicpService {

    @Autowired
    MercanciasicpRepository mercanciasicpRepository;

    public ArrayList<MercanciaicpModel> obtenerMercanciaicp() {
        return (ArrayList<MercanciaicpModel>) mercanciasicpRepository.findAll();
    }

    public MercanciaicpModel registrarMercancia(MercanciaicpModel mercancia) {
        return mercanciasicpRepository.save(mercancia);
    }
}
