package com.appchoferes.nomina.modules.combustible.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appchoferes.nomina.config.DatabaseContextHolder;
import com.appchoferes.nomina.modules.combustible.dtos.KmCamionDTO;
import com.appchoferes.nomina.modules.combustible.repositories.KmCamionRepository;

@Service
public class kmCamionService {

    @Autowired
    private KmCamionRepository kmCamionRepository;

    public List<KmCamionDTO> getKmCamion(Long camionId, String fechaAnterior, String fechaActual) {

        DatabaseContextHolder.setDatabaseType("lorasdb");

        List<Object[]> kmCamion = kmCamionRepository.getKmCamion(camionId, fechaAnterior, fechaActual);

        DatabaseContextHolder.clearDatabaseType();

        return kmCamion.stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    private KmCamionDTO mapToDTO(Object[] result) {
        return KmCamionDTO.builder()
                .km(getDouble(result[0]))
                .build();
    }

    private Double getDouble(Object obj) {
        return obj instanceof Number ? ((Number) obj).doubleValue() : null;
    }

}
