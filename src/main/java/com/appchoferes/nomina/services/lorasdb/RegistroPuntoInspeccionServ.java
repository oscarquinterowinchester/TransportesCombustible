package com.appchoferes.nomina.services.lorasdb;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appchoferes.nomina.models.lorasdb.dtos.PuntosSemanalProjection;
import com.appchoferes.nomina.repositories.lorasdb.RegistroPuntoInspeccionRepo;

@Service
public class RegistroPuntoInspeccionServ {

    @Autowired
    private RegistroPuntoInspeccionRepo registroPuntoInspeccionRepository;

 public List<PuntosSemanalProjection> getListaPuntosGuardadosSemanal() {
        return registroPuntoInspeccionRepository.findPuntosGuardadosSemanal();
    }
}
