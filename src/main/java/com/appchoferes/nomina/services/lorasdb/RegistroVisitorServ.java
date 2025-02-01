package com.appchoferes.nomina.services.lorasdb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appchoferes.nomina.models.lorasdb.dtos.RegistroHistorialDTO;
import com.appchoferes.nomina.repositories.lorasdb.VisitorRegistroRepo;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RegistroVisitorServ {

    @Autowired
    private VisitorRegistroRepo registroRepository;

    public List<RegistroHistorialDTO> getRegistrosHistorial(Integer id, String inicio, String fin) {
        List<Object[]> registros = registroRepository.findRegistrosHistorial(id, inicio, fin);

        return registros.stream().map(registro -> {
            RegistroHistorialDTO dto = new RegistroHistorialDTO();
            dto.setId((Integer) registro[0]); // id es Integer
            dto.setEntrada(convertToLocalDateTime((Timestamp) registro[1])); // entrada es Timestamp
            dto.setVisitanteId((Integer) registro[2]); // visitanteID es Integer
            dto.setNombre((String) registro[3]); // nombre es String
            dto.setEmpresa((String) registro[4]); // empresa es String
            dto.setAsunto((String) registro[5]); // asunto es String
            dto.setEmpleado((String) registro[6]); // empleado es String
            dto.setIdentificacion((String) registro[7]); // identificacion es String
            dto.setGafete((String) registro[8]); // gafete es String
            dto.setVehiculo((String) registro[9]); // vehiculo es String
            dto.setSalida(convertToLocalDateTime((Timestamp) registro[10])); // salida es Timestamp
            dto.setDuracion((String) registro[11]); // duracion es String
            dto.setFirma((byte[]) registro[12]); // firma es byte[]
            dto.setFecha(convertToLocalDateTime((Timestamp) registro[13])); // fecha es Timestamp
            dto.setEmpresaId((Long) registro[14]); // empresaID es Long
            dto.setArchivoGenerado((Boolean) registro[15]); // ArchivoGenerado es Boolean
            dto.setGafeteId((Long) registro[16]); // gafeteID es Long
            dto.setPatioId((Integer) registro[17]); // PatioID es Integer
            dto.setFoto((String) registro[18]); // foto es String
            dto.setFirmaVisitante((String) registro[19]); // firma es String
            dto.setIdentificacionVisitante((String) registro[20]); // identificacion es String
            dto.setIdentificacion2Visitante((String) registro[21]); // identificacion2 es String
            dto.setCompania((String) registro[22]); // compania es String
            dto.setCompletado(((Long) registro[23]) == 1); // completado es Boolean (0 o 1)
            return dto;
        }).collect(Collectors.toList());
    }

    private LocalDateTime convertToLocalDateTime(Timestamp timestamp) {
        return timestamp != null ? timestamp.toLocalDateTime() : null;
    }
}