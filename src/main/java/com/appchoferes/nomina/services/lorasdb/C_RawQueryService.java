package com.appchoferes.nomina.services.lorasdb;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appchoferes.nomina.models.lorasdb.dtos.CamionesConCargaDTO;
import com.appchoferes.nomina.models.lorasdb.dtos.HistorialCargasDTO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

// Este servicio contiene logica para el modulo de combustible
@Service
public class C_RawQueryService {

    @Autowired
    private EntityManager entityManager;

    public List<CamionesConCargaDTO> getCamionesConCarga() {

        String sql = "call com_getCamionesTablaDiesel()";

        Query query = entityManager.createNativeQuery(sql);
        List<Object[]> result = query.getResultList();

        return result.stream().map(row -> new CamionesConCargaDTO(
                ((Number) row[0]).longValue(), // id
                (String) row[1], // noEconomico
                ((Number) row[2]).doubleValue(), // rendimientoCamion
                row[3] != null ? ((Number) row[3]).doubleValue() : 0.0, // tanquePorcentajeLleno
                ((Number) row[4]).doubleValue(), // tanqueCapacidad
                row[5] != null ? ((Number) row[5]).doubleValue() : 0.0, // rendimiento
                ((Number) row[6]).doubleValue() // tanqueActual
        )).collect(Collectors.toList());
    }

    public List<HistorialCargasDTO> getHistorialCargas(Long id, Integer tipo) {

        String sql = "call com_getCombustibleHistorial(:id, :tipo)";

        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("id", id);
        query.setParameter("tipo", tipo);
        List<Object[]> result = query.getResultList();

        for (Object[] row : result) {
            System.out.println(Arrays.toString(row));
        }

        return result.stream().map(row -> new HistorialCargasDTO(
                row[0] instanceof Number ? ((Number) row[0]).longValue() : 0L, // cargaId
                row[1] instanceof String ? (String) row[1] : "", // proveedor
                row[2] instanceof Number ? ((Number) row[2]).doubleValue() : 0.0, // litros
                row[3] instanceof String ? (String) row[3] : "", // historialNota
                row[4] instanceof String ? (String) row[4] : "", // sellos
                row[5] instanceof String ? (String) row[5] : "", // fotoSello
                row[6] instanceof Timestamp ? ((Timestamp) row[6]).toLocalDateTime() : null, // fecha
                row[7] instanceof BigDecimal ? (BigDecimal) row[7]
                        : (row[7] instanceof Number ? BigDecimal.valueOf(((Number) row[7]).doubleValue())
                                : BigDecimal.ZERO), // rendimientoCarga
                row[8] instanceof BigDecimal ? (BigDecimal) row[8]
                        : (row[8] instanceof Number ? BigDecimal.valueOf(((Number) row[8]).doubleValue())
                                : BigDecimal.ZERO), // rendimientoECM
                row[9] instanceof BigDecimal ? (BigDecimal) row[9]
                        : (row[9] instanceof Number ? BigDecimal.valueOf(((Number) row[9]).doubleValue())
                                : BigDecimal.ZERO) // rendimientoRutas
        )).collect(Collectors.toList());
    }

}
