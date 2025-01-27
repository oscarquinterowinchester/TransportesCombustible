package com.appchoferes.nomina.services.lorasdb;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appchoferes.nomina.models.lorasdb.dtos.CamionesConCargaDTO;
import com.appchoferes.nomina.models.lorasdb.dtos.CamionesPatios;
import com.appchoferes.nomina.repositories.lorasdb.CamionesConCargaRepository;

@Service
public class CamionesConCargaService {

    @Autowired
    private CamionesConCargaRepository camionesConCargaRepository;

    // Metodo para recuperar camiones del modulo Patios
    public List<CamionesPatios> getCamionesDePatios() {
        List<Object[]> resultados = camionesConCargaRepository.getCamionesPatiosRaw();

        // Mapeo manual de los resultados al DTO
        return resultados.stream()
                .map(obj -> new CamionesPatios(((Number) obj[0]).longValue(), (String) obj[1]))
                .collect(Collectors.toList());
    }

    public List<CamionesConCargaDTO> getAllCamionesConCargas() {

        List<Object[]> camionesRaw = camionesConCargaRepository.getCamionesConCargasRaw();
        return camionesRaw.stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    public CamionesConCargaDTO getCamion(Long id) {
        List<Object[]> result = camionesConCargaRepository.getCamionRaw(id);
        return mapToDTO(result.get(0)); // Recuperamos el primer registro
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

    private Long getLong(Object obj) {
        return obj instanceof Number ? ((Number) obj).longValue() : null;
    }

    private Double getDouble(Object obj) {
        return obj instanceof Number ? ((Number) obj).doubleValue() : 0.0;
    }

    private String getString(Object obj) {
        return obj != null ? obj.toString() : null;
    }

}
