package com.appchoferes.nomina.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appchoferes.nomina.config.DatabaseContextHolder;
import com.appchoferes.nomina.models.MetodosPago;
import com.appchoferes.nomina.repositories.IMetodosPagoRepository;

@Service
public class MetodosPagoService {

    @Autowired
    IMetodosPagoRepository metodosPagoRepository;

    public ArrayList<MetodosPago> getMetodosPagos(String dbType){
        DatabaseContextHolder.setDatabaseType(dbType);
        return (ArrayList<MetodosPago>) metodosPagoRepository.getMetodosPago();
    }


}