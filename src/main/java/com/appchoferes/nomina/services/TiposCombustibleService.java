package com.appchoferes.nomina.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appchoferes.nomina.config.DatabaseContextHolder;
import com.appchoferes.nomina.dtos.TipoCombustible;
import com.appchoferes.nomina.repositories.ITiposCombustibleRepository;

@Service
public class TiposCombustibleService {

    @Autowired
    ITiposCombustibleRepository tiposCombustibleRepository;

    public ArrayList<TipoCombustible> getTipoCombustibles(String dbType){
        DatabaseContextHolder.setDatabaseType(dbType);
        return (ArrayList<TipoCombustible>) tiposCombustibleRepository.getTipoCombustible();
    }

}
