package com.appchoferes.nomina.services.lorasdb;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appchoferes.nomina.models.lorasdb.RegistroCorrespondencia;
import com.appchoferes.nomina.repositories.lorasdb.RegistroCorrespondenciaRepo;

@Service
public class RegistroCorrespondenciaServ {

    @Autowired
    private RegistroCorrespondenciaRepo rCrepo;

    public List<RegistroCorrespondencia> getRegistrosC(){
        List<RegistroCorrespondencia> registrosC = rCrepo.getRegistrosC();
        return registrosC;
    }
}
