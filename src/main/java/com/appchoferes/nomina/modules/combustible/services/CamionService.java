package com.appchoferes.nomina.modules.combustible.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appchoferes.nomina.config.DatabaseContextHolder;
import com.appchoferes.nomina.modules.combustible.dtos.CamionConCargaDTO;
import com.appchoferes.nomina.modules.combustible.repositories.CamionRepository;

@Service
public class CamionService {

    @Autowired
    private CamionRepository camionRepository;

    public List<CamionConCargaDTO> getAllCamionesConCargas(){

        DatabaseContextHolder.setDatabaseType("lorasdb");

        List<Object[]> camionesRaw = camionRepository.getCamionesConCargasRaw();

        DatabaseContextHolder.clearDatabaseType();

        List<CamionConCargaDTO> camiones = new ArrayList<>();
        for (Object[] result : camionesRaw) {
            CamionConCargaDTO camion = new CamionConCargaDTO();

            camion.setCamionId(((Number) result[0]).longValue());
            camion.setNoEconomico(result[1] != null ? result[1].toString() : null);

            camion.setRendimientoCamion(result[2] != null ? ((Number) result[2]).doubleValue() : 0.0);
            camion.setTanquePorcentajeLleno(result[3] != null ? ((Number) result[3]).doubleValue() : 0.0);
            camion.setTanqueCapacidad(result[4] != null ? ((Number) result[4]).doubleValue() : 0.0);
            camion.setTanqueActual(result[5] != null ? ((Number) result[5]).doubleValue() : 0.0);

            camiones.add(camion);

        }

        return camiones;
    }
} 

