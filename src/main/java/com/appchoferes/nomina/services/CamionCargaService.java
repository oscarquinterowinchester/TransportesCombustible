package com.appchoferes.nomina.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appchoferes.nomina.config.DatabaseContextHolder;
import com.appchoferes.nomina.dtos.CamionCarga;
import com.appchoferes.nomina.repositories.ICamionCargaRepository;

@Service
public class CamionCargaService {

    @Autowired
    ICamionCargaRepository vistaCamionCarga;

    public CamionCarga getVistaCamionCargas(String choferId,String dbType){
        DatabaseContextHolder.setDatabaseType(dbType);
        return vistaCamionCarga.getCamionCarga(choferId);

    }


}
