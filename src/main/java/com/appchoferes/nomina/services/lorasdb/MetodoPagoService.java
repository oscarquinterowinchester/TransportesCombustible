package com.appchoferes.nomina.services.lorasdb;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appchoferes.nomina.models.lorasdb.dtos.MetodoPagoDTO;
import com.appchoferes.nomina.repositories.lorasdb.MetodoPagoRepository;


@Service
public class MetodoPagoService {
    
    @Autowired
    private MetodoPagoRepository metodoPagoRepository;

    public List<MetodoPagoDTO> getMetodosPago(){
        List<Object[]> mPagoRaw = metodoPagoRepository.getMetodosPagoRaw();

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
