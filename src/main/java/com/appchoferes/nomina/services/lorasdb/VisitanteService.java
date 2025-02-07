package com.appchoferes.nomina.services.lorasdb;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appchoferes.nomina.models.lorasdb.dtos.BusquedaVisitanteDTO;
import com.appchoferes.nomina.repositories.lorasdb.VisitorVisitanteRepo;

@Service
public class VisitanteService {

    @Autowired
    private VisitorVisitanteRepo visitanteRepository;

    public List<BusquedaVisitanteDTO> buscarVisitantes(String word) {
        List<Object[]> resultados = visitanteRepository.buscarVisitantes(word);

        return resultados.stream()
            .map(this::mapearABusquedaVisitanteDTO)
            .collect(Collectors.toList());
    }

    private BusquedaVisitanteDTO mapearABusquedaVisitanteDTO(Object[] resultado) {
        return new BusquedaVisitanteDTO(
            ((Number) resultado[0]).longValue(), // id
            (String) resultado[1], // nombre
            resultado[2] != null ? ((Number) resultado[2]).longValue() : null, // empresaID
            resultado[3] != null ? ((Number) resultado[3]).longValue() : null, // tipoVisitante
            ((Number) resultado[4]).intValue(), // visto
            (String) resultado[5], // empresa
            (String) resultado[6], // tipo
            ((Timestamp) resultado[7]).toLocalDateTime(), // last
            ((Number) resultado[8]).longValue(), // exist
            (String) resultado[9], // foto
            (String) resultado[10] // identificacion
        );
    }
}