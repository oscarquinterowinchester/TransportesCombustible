package com.appchoferes.nomina.services.lorasdb;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appchoferes.nomina.models.lorasdb.EstadosPais;
import com.appchoferes.nomina.repositories.lorasdb.EstadosPaisRepo;

@Service
public class EstadosPaisServ {

    @Autowired
    private EstadosPaisRepo estadosPaisRepo;

    public List<EstadosPais> getEstadosPorPais(Integer paisID) {
        return estadosPaisRepo.getEstadosPais(paisID);
    }
}
