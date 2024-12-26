package com.appchoferes.nomina.modules.combustible.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

        return camionesRaw.stream()
                .map(this :: mapToDTO)
                .collect(Collectors.toList());

    }

    public CamionesConCargaDTO getCamion(Long id) {

        DatabaseContextHolder.setDatabaseType("lorasdb");

        List<Object[]> result = camionesConCargaRepository.getCamionRaw(id);

        DatabaseContextHolder.clearDatabaseType();

        return mapToDTO(result.get(0)); //Recuperamos el primer registro
    }


    private CamionesConCargaDTO mapToDTO(Object[] result) {
        return CamionesConCargaDTO.builder()
        .id(getLong(result[0]))
        .noEconomico(getString(result[1]))
        .rendimientoCamion(getDouble(result[2]))
        .tanquePorcentajeLleno(getDouble(result[3]))
        .tanqueCapacidad(getDouble(result[4]))
        .tanqueActual(getDouble(result[5]))
        .build();
    }

    private Long getLong(Object obj){
        return obj instanceof Number ? ((Number) obj).longValue() : null;
    }

    private Double getDouble(Object obj){
        return obj instanceof Number ? ((Number) obj).doubleValue() : 0.0;
    }

    private String getString(Object obj){
        return obj != null ? obj.toString() : null;
    }

} 

