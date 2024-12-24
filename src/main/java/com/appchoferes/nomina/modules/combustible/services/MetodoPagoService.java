package com.appchoferes.nomina.modules.combustible.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appchoferes.nomina.config.DatabaseContextHolder;
import com.appchoferes.nomina.modules.combustible.dtos.MetodoPagoDTO;
import com.appchoferes.nomina.modules.combustible.repositories.MetodoPagoRepository;

@Service
public class MetodoPagoService {
    
    @Autowired
    private MetodoPagoRepository metodoPagoRepository;

    public List<MetodoPagoDTO> getMetodosPago(){
        DatabaseContextHolder.setDatabaseType("lorasdb");

        List<Object[]> mPagoRaw = metodoPagoRepository.getMetodosPagoRaw();

        DatabaseContextHolder.clearDatabaseType();

        List<MetodoPagoDTO> metodosPago = new ArrayList<>();
        for (Object [] result : mPagoRaw) {
            MetodoPagoDTO mPago = new MetodoPagoDTO();

            mPago.setMetodoId(((Number) result[0]).intValue());
            mPago.setNombre(result[1] != null ? result[1].toString() : null);

            metodosPago.add(mPago);
        }

        return metodosPago;
    }

}
