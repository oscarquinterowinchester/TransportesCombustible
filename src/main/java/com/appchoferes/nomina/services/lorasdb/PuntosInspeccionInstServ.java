package com.appchoferes.nomina.services.lorasdb;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appchoferes.nomina.models.lorasdb.PuntosInspeccionInstalaciones;
import com.appchoferes.nomina.repositories.lorasdb.PuntosInspeccionInstRepo;

@Service
public class PuntosInspeccionInstServ {

    @Autowired
    private PuntosInspeccionInstRepo piiRepo;

    public List<PuntosInspeccionInstalaciones> getPuntosInspeccionInstalaciones(){
        List<PuntosInspeccionInstalaciones> puntosInspInst = piiRepo.getPuntosInspeccionInstalaciones();
        return puntosInspInst;
    }

}
