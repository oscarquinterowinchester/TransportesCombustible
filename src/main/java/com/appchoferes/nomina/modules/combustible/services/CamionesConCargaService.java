package com.appchoferes.nomina.modules.combustible.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appchoferes.nomina.config.DatabaseContextHolder;
import com.appchoferes.nomina.modules.combustible.dtos.CamionesConCargaDTO;
import com.appchoferes.nomina.modules.combustible.repositories.CamionesConCargaRepository;

@Service
public class CamionesConCargaService {

    @Autowired
    private CamionesConCargaRepository camionesConCargaRepository;

    public List<CamionesConCargaDTO> getAllCamionesConCargas(){

        DatabaseContextHolder.setDatabaseType("lorasdb");

        List<Object[]> camionesRaw = camionesConCargaRepository.getCamionesConCargasRaw();

        DatabaseContextHolder.clearDatabaseType();

        List<CamionesConCargaDTO> camiones = new ArrayList<>();

        for (Object[] result : camionesRaw) {
            CamionesConCargaDTO camion = mapToDTO(result);
            camiones.add(camion);
        }
        return camiones;
    }

    public CamionesConCargaDTO getCamion(Long id) {

        DatabaseContextHolder.setDatabaseType("lorasdb");

        List<Object[]> result = camionesConCargaRepository.getCamionRaw(id);

        DatabaseContextHolder.clearDatabaseType();

        return mapToDTO(result.get(0)); //Recuperamos el primer registro
    }


    private CamionesConCargaDTO mapToDTO(Object[] result) {

        CamionesConCargaDTO camion = new CamionesConCargaDTO();

        camion.setId(result[0] instanceof Number ? ((Number) result[0]).longValue() : null);
        camion.setNoEconomico(result[1] != null ? result[1].toString() : null);
        camion.setRendimientoCamion(result[2] instanceof Number ? ((Number) result[2]).doubleValue() : 0.0);
        camion.setTanquePorcentajeLleno(result[3] instanceof Number ? ((Number) result[3]).doubleValue() : 0.0);
        camion.setTanqueCapacidad(result[4] instanceof Number ? ((Number) result[4]).doubleValue() : 0.0);
        camion.setTanqueActual(result[5] instanceof Number ? ((Number) result[5]).doubleValue() : 0.0);

        return camion;
    }

} 

