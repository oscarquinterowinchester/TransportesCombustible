package com.appchoferes.nomina.services.durandb;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appchoferes.nomina.models.durandb.TarifasucModel;
import com.appchoferes.nomina.repositories.durandb.TarifasucRepository;

@Service
public class TarifasucService {

    @Autowired
    TarifasucRepository tarifasucRepository;

    public ArrayList<TarifasucModel> obtenerTarifasuc() {
        return (ArrayList<TarifasucModel>) tarifasucRepository.findAll();
    }

    public TarifasucModel registrarTarifasuc(TarifasucModel tarifas) {
        return tarifasucRepository.save(tarifas);
    }
}
