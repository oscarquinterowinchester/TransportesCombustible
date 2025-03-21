package com.appchoferes.nomina.services.lorasdb;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appchoferes.nomina.models.lorasdb.ListadoInspeccion;
import com.appchoferes.nomina.repositories.lorasdb.ListadoInspRepo;

@Service
public class ListadoInspServ {
    
    @Autowired
    private ListadoInspRepo listadoInspRepo;

    public List<ListadoInspeccion> getListadoInspeccion(Integer itinerarioID) {
        return listadoInspRepo.obtieneListadoInspeccion(itinerarioID);
    }
}


