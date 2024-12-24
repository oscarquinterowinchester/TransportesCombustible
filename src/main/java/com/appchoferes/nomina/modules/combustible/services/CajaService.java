package com.appchoferes.nomina.modules.combustible.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appchoferes.nomina.config.DatabaseContextHolder;
import com.appchoferes.nomina.modules.combustible.dtos.CajaConCargaDTO;
import com.appchoferes.nomina.modules.combustible.repositories.CajaRepository;

@Service
public class CajaService {

    @Autowired
    private CajaRepository cajaRepository;

    public List<CajaConCargaDTO> getAllCajasConCarga(){
        DatabaseContextHolder.setDatabaseType("lorasdb");

        List<Object[]> cajasRaw = cajaRepository.getCajasConCargasRaw();

        DatabaseContextHolder.clearDatabaseType();

        List<CajaConCargaDTO> cajas = new ArrayList<>();
        for (Object [] result : cajasRaw) {
            CajaConCargaDTO caja = new CajaConCargaDTO();

            caja.setCajaId(((Number) result[0]).longValue());
            caja.setNoEconomico(result[1] != null ? result[1].toString() : null);


            caja.setTanqueCapacidad(result[2] != null ? ((Number) result[4]).doubleValue() : 0.0);
            caja.setTanqueActual(result[3] != null ? ((Number) result[5]).doubleValue() : 0.0);

            cajas.add(caja);
        }

        return cajas;
    }
}
