package com.appchoferes.nomina.services.lorasdb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appchoferes.nomina.models.lorasdb.dtos.RegistroHistorialDTO;
import com.appchoferes.nomina.models.lorasdb.dtos.RegistroPendientesDTO;
import com.appchoferes.nomina.repositories.lorasdb.VisitorRegistroRepo;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RegistroVisitorServ {

    @Autowired
    private VisitorRegistroRepo registroRepository;

    // getRegistrosHistorial
    public List<RegistroHistorialDTO> getRegistrosHistorial(Long id, LocalDateTime inicio, LocalDateTime finalDate) {
        List<Object[]> resultados = registroRepository.findRegistrosHistorial(id, inicio, finalDate);

        return resultados.stream()
                .map(this::mapearARegistroHistorialDTO)
                .collect(Collectors.toList());
    }

    private RegistroHistorialDTO mapearARegistroHistorialDTO(Object[] resultado) {
        return new RegistroHistorialDTO(
                ((Number) resultado[0]).longValue(), // id
                ((Timestamp) resultado[1]).toLocalDateTime(), // fecha
                (String) resultado[2], // foto
                (String) resultado[3], // firma
                (String) resultado[4], // identificacion
                (String) resultado[5], // identificacion2
                (String) resultado[6], // compania
                ((Number) resultado[7]).intValue() // completado
        );
    }

    public List<RegistroPendientesDTO> getRegistrosPendientes(Long id, LocalDateTime inicio, LocalDateTime finalDate) {
        List<Object[]> resultados = registroRepository.findRegistrosPendientes(id, inicio, finalDate);

        return resultados.stream()
                .map(this::mapearARegistroPendienteDTO)
                .collect(Collectors.toList());
    }

    private RegistroPendientesDTO mapearARegistroPendienteDTO(Object[] resultado) {
        return new RegistroPendientesDTO(
            resultado[0] != null ? ((Number) resultado[0]).longValue() : null, // id
            resultado[1] != null ? ((Timestamp) resultado[1]).toLocalDateTime() : null, // entrada
            resultado[2] != null ? ((Number) resultado[2]).longValue() : null, // visitanteID
            (String) resultado[3], // nombre
            (String) resultado[4], // empresa
            (String) resultado[5], // asunto
            (String) resultado[6], // empleado
            (String) resultado[7], // identificacion
            (String) resultado[8], // gafete
            (String) resultado[9], // vehiculo
            resultado[10] != null ? ((Timestamp) resultado[10]).toLocalDateTime() : null, // salida
            (String) resultado[11], // duracion
            (String) resultado[12], // firma
            resultado[13] != null ? ((Timestamp) resultado[13]).toLocalDateTime() : null, // fecha
            resultado[14] != null ? ((Number) resultado[14]).longValue() : null, // empresaID
            resultado[15] != null ? ((Boolean) resultado[15]).booleanValue() : null, // archivoGenerado
            resultado[16] != null ? ((Number) resultado[16]).longValue() : null, // gafeteID
            resultado[17] != null ? ((Number) resultado[17]).longValue() : null, // patioID
            (String) resultado[18], // foto
            (String) resultado[19], // firmaVisitante
            (String) resultado[20], // identificacion2
            (String) resultado[21], // compania
            resultado[22] != null ? ((Number) resultado[22]).intValue() : null // completado
        );
    }
}