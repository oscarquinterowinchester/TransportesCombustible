package com.appchoferes.nomina.services.lorasdb;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appchoferes.nomina.models.lorasdb.dtos.ItinerarioDTO;
import com.appchoferes.nomina.repositories.lorasdb.CombustibleItinerarioRepository;


@Service
public class CombustibleItinerarioService {

    @Autowired
    private CombustibleItinerarioRepository combustibleItinerarioRepository;

    public List<ItinerarioDTO> getItinerarioCamion(
                Long camionId, 
                String fechaAnterior, 
                String fechaActual){
        List<Object[]> itinerarioCamion = combustibleItinerarioRepository
                .getItinetariosCamion(camionId, fechaAnterior, fechaActual);

        return itinerarioCamion.stream()
                .map(this :: mapToDTO)
                .collect(Collectors.toList());

    }

    private ItinerarioDTO mapToDTO(Object[] result){
        return ItinerarioDTO.builder()
                .itinerarioId(getLong(result[0]))
                .estadoCarga(getString(result[1]))
                .km(getDouble(result[2]))
                .ruta(getString(result[3]))
                .rendimientoCamion(getDouble(result[4]))
                .chofer(getString(result[5]))
                .camion(getString(result[6]))
                .caja(getString(result[7]))
                .fechaLlegada(getString(result[8]))
                .odometrosS(getDouble(result[9]))
                .odometrosS(getDouble(result[10]))
                .recorrido(getDouble(result[11]))
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
