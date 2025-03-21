package com.appchoferes.nomina.services.lorasdb;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appchoferes.nomina.models.lorasdb.TipoCorrespondencia;
import com.appchoferes.nomina.repositories.lorasdb.TipoCorrespondenciaRepo;

@Service
public class TipoCorrespondeciaServ {

    @Autowired
    private TipoCorrespondenciaRepo tipoCorrespondenciaRepo;

    public List<TipoCorrespondencia> getAllTiposCorrespondencia() {
        List<TipoCorrespondencia> tiposCorrespondencia = tipoCorrespondenciaRepo.findAll();
        return tiposCorrespondencia;
    }

}
