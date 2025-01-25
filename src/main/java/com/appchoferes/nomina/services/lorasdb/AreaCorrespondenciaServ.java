package com.appchoferes.nomina.services.lorasdb;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appchoferes.nomina.models.lorasdb.AreaCorrespondencia;
import com.appchoferes.nomina.repositories.lorasdb.AreaCorrespondenciaRepo;

@Service
public class AreaCorrespondenciaServ {

    @Autowired
    private AreaCorrespondenciaRepo areaCorrespondenciaRepo;

    public List<AreaCorrespondencia> getAllAreasCorrespondencia() {
        List<AreaCorrespondencia> areas = areaCorrespondenciaRepo.findAll();
        return areas;
    }

}
