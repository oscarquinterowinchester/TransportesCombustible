package com.appchoferes.nomina.services.lorasdb;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appchoferes.nomina.models.lorasdb.dtos.CamionesConCargaDTO;
import com.appchoferes.nomina.models.lorasdb.dtos.HistorialCargasDTO;
import com.appchoferes.nomina.utils.S3Service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

// Este servicio contiene logica para el modulo de combustible
@Service
public class C_RawQueryService {

        @Autowired
        private EntityManager entityManager;

        @Autowired
        private S3Service s3Service;

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

                // Define el formato de la fecha (
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

                return result.stream().map(row -> {
                        // Obtiene la ruta del archivo
                        String fotoSello = row[5] instanceof String ? (String) row[5] : "";

                        // Genera la URL firmada para fotoSello
                        String urlFirmada = "";
                        if (!fotoSello.isEmpty()) {
                                try {
                                        // Extrae la carpeta y el nombre del archivo de la URL
                                        String[] partes = fotoSello.split("/");
                                        String folder = "patios/carga/sellos"; // Ruta completa de la carpeta
                                        String fileNameWithExtension = partes[partes.length - 1]; // Nombre del archivo
                                                                                                  // con extensión (ej:
                                                                                                  // "sello_42_2025-03-12.png")
                                        String fileName = fileNameWithExtension.split("\\.")[0]; // Nombre del archivo
                                                                                                 // sin extensión (ej:
                                                                                                 // "sello_42_2025-03-12")
                                        // String idArchivo = fileName.split("_")[1]; // ID del archivo (ej: "42")

                                        // Genera la URL firmada
                                        urlFirmada = s3Service.generarUrlFirmada(folder, fileName);
                                } catch (Exception e) {
                                        e.printStackTrace();
                                        // Si ocurre un error, usa la URL original
                                        urlFirmada = fotoSello;
                                }
                        }

                        // Crea el DTO con la URL firmada
                        return new HistorialCargasDTO(
                                        row[0] instanceof Number ? ((Number) row[0]).longValue() : 0L, // cargaId
                                        row[1] instanceof String ? (String) row[1] : "", // proveedor
                                        row[2] instanceof Number ? ((Number) row[2]).doubleValue() : 0.0, // litros
                                        row[3] instanceof String ? (String) row[3] : "", // historialNota
                                        row[4] instanceof String ? (String) row[4] : "", // sellos
                                        urlFirmada, // fotoSello (URL firmada)
                                        row[6] instanceof Timestamp ? ((Timestamp) row[6]).toLocalDateTime() : // Si es
                                                                                                               // Timestamp
                                                        (row[6] instanceof String
                                                                        ? LocalDateTime.parse((String) row[6],
                                                                                        formatter)
                                                                        : null), // Si
                                                                                 // es
                                                                                 // String
                                        row[7] instanceof BigDecimal ? (BigDecimal) row[7]
                                                        : (row[7] instanceof Number
                                                                        ? BigDecimal.valueOf(
                                                                                        ((Number) row[7]).doubleValue())
                                                                        : BigDecimal.ZERO), // rendimientoCarga
                                        row[8] instanceof BigDecimal ? (BigDecimal) row[8]
                                                        : (row[8] instanceof Number
                                                                        ? BigDecimal.valueOf(
                                                                                        ((Number) row[8]).doubleValue())
                                                                        : BigDecimal.ZERO), // rendimientoECM
                                        row[9] instanceof BigDecimal ? (BigDecimal) row[9]
                                                        : (row[9] instanceof Number
                                                                        ? BigDecimal.valueOf(
                                                                                        ((Number) row[9]).doubleValue())
                                                                        : BigDecimal.ZERO) // rendimientoRutas
                        );
                }).collect(Collectors.toList());
        }

}
