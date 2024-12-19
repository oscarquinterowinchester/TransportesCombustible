package com.appchoferes.nomina.services;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appchoferes.nomina.config.DatabaseContextHolder;
import com.appchoferes.nomina.dtos.CargasDiesel;
import com.appchoferes.nomina.repositories.ICargasDieselRepository;

@Service
public class CargasDieselService {
    @Autowired
    ICargasDieselRepository cargasDieselRepository;

    public ArrayList<CargasDiesel> getCargasDiesel(String choferId,String dbType)
    {
        DatabaseContextHolder.setDatabaseType(dbType);
        return (ArrayList<CargasDiesel>) cargasDieselRepository.getCargasDiesel(choferId);
    }

}