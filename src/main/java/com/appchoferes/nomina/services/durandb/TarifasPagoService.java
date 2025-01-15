package com.appchoferes.nomina.services.durandb;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appchoferes.nomina.models.durandb.TarifasPagoModel;
import com.appchoferes.nomina.repositories.durandb.TarifasPagoRepository;

@Service
public class TarifasPagoService {

    @Autowired
    TarifasPagoRepository tarifasPagoRepository;

    public ArrayList<TarifasPagoModel> obtenerTarifasPago() {
        return (ArrayList<TarifasPagoModel>) tarifasPagoRepository.findAll();
    }
}
