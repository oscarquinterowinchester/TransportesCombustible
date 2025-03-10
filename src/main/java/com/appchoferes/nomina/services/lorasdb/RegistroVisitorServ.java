package com.appchoferes.nomina.services.lorasdb;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appchoferes.nomina.models.lorasdb.dtos.RegistroHistorialDTO;
import com.appchoferes.nomina.models.lorasdb.dtos.RegistroPendientesDTO;
import com.appchoferes.nomina.repositories.lorasdb.VisitorRegistroRepo;

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
                resultado[0] != null ? ((Number) resultado[0]).longValue() : null, // id
                resultado[1] != null ? ((Timestamp) resultado[1]).toLocalDateTime() : null, // fecha
                (String) resultado[11], // foto (índice 11)
                (String) resultado[12], // firma (índice 12)
                (String) resultado[13], // identificación (índice 13)
                (String) resultado[14], // identificación2 (índice 14)
                (String) resultado[15], // compañía (índice 15)
                resultado[16] != null ? ((Number) resultado[16]).intValue() : null, // completado (índice 16)
                resultado[2] != null ? ((Timestamp) resultado[2]).toLocalDateTime() : null, // entrada (índice 2)
                (String) resultado[3], // asunto (índice 3)
                (String) resultado[17], // nombre (nombreVisitante) (índice 17)
                resultado[4] != null ? ((Number) resultado[4]).intValue() : null, // visitanteID (índice 4)
                (String) resultado[5], // gafete (índice 5)
                (String) resultado[6], // vehículo (índice 6)
                resultado[7] != null ? ((Timestamp) resultado[7]).toLocalDateTime() : null, // salida (índice 7)
                (String) resultado[8], // empleado (índice 8)
                (String) resultado[9], // duración (índice 9)
                resultado[10] != null ? (Boolean) resultado[10] : null // archivoGenerado (índice 10)
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
                resultado[0] instanceof Number ? ((Number) resultado[0]).longValue() : null, // id
                resultado[1] instanceof Timestamp ? ((Timestamp) resultado[1]).toLocalDateTime() : null, // entrada
                resultado[2] instanceof Number ? ((Number) resultado[2]).longValue() : null, // visitanteID
                resultado[3] != null ? resultado[3].toString() : null, // nombre
                resultado[4] != null ? resultado[4].toString() : null, // empresa
                resultado[5] != null ? resultado[5].toString() : null, // asunto
                resultado[6] != null ? resultado[6].toString() : null, // empleado
                resultado[7] != null ? resultado[7].toString() : null, // identificacion
                resultado[8] != null ? resultado[8].toString() : null, // gafete
                resultado[9] != null ? resultado[9].toString() : null, // vehiculo
                resultado[10] instanceof Timestamp ? ((Timestamp) resultado[10]).toLocalDateTime() : null, // salida
                resultado[11] != null ? resultado[11].toString() : null, // duracion
                resultado[12] != null ? resultado[12].toString() : null, // firma
                resultado[13] instanceof Timestamp ? ((Timestamp) resultado[13]).toLocalDateTime() : null, // fecha
                resultado[14] instanceof Number ? ((Number) resultado[14]).longValue() : null, // empresaID
                resultado[15] instanceof Boolean ? (Boolean) resultado[15]
                        : (resultado[15] instanceof Number ? ((Number) resultado[15]).intValue() == 1 : null), // archivoGenerado
                resultado[16] instanceof Number ? ((Number) resultado[16]).longValue() : null, // gafeteID
                resultado[17] instanceof Number ? ((Number) resultado[17]).longValue() : null, // patioID
                resultado[18] != null ? resultado[18].toString() : null, // foto
                resultado[19] != null ? resultado[19].toString() : null, // firmaVisitante
                resultado[20] != null ? resultado[20].toString() : null, // identificacion2
                resultado[21] != null ? resultado[21].toString() : null, // compania
                resultado[22] instanceof Number ? ((Number) resultado[22]).intValue() : null // completado
        );
    }

}