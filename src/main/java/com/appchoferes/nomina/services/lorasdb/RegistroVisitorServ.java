package com.appchoferes.nomina.services.lorasdb;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appchoferes.nomina.models.lorasdb.dtos.RegistroPendientesDTO;
import com.appchoferes.nomina.repositories.lorasdb.VisitorRegistroRepo;
import com.appchoferes.nomina.utils.S3Service;

@Service
public class RegistroVisitorServ {

    @Autowired
    private VisitorRegistroRepo registroRepository;

    @Autowired
    private S3Service s3Service;

    // getRegistrosHistorial
    public List<RegistroPendientesDTO> getRegistrosPendientes(Long id, LocalDateTime inicio, LocalDateTime finalDate) {
        List<Object[]> resultados = registroRepository.findRegistrosPendientes(id, inicio, finalDate);

        return resultados.stream()
                .map(this::mapearARegistroPendienteDTO)
                .collect(Collectors.toList());
    }

    private RegistroPendientesDTO mapearARegistroPendienteDTO(Object[] resultado) {
        // Obtener las URLs de las imágenes
        String identificacionUrl = firmarUrl(resultado[7] != null ? resultado[7].toString() : null,
                "visitantes/identificaciones");
        String identificacion2Url = firmarUrl(resultado[20] != null ? resultado[20].toString() : null,
                "visitantes/identificaciones");
        String fotoUrl = firmarUrl(resultado[18] != null ? resultado[18].toString() : null, "visitantes/fotos");

        String firmaUrl = firmarUrl(resultado[19] != null ? resultado[19].toString() : null, "visitantes/firmas");

        return new RegistroPendientesDTO(
                resultado[0] instanceof Number ? ((Number) resultado[0]).longValue() : null, // id
                resultado[1] instanceof Timestamp ? ((Timestamp) resultado[1]).toLocalDateTime() : null, // entrada
                resultado[2] instanceof Number ? ((Number) resultado[2]).longValue() : null, // visitanteID
                resultado[3] != null ? resultado[3].toString() : null, // nombre
                resultado[4] != null ? resultado[4].toString() : null, // empresa
                resultado[5] != null ? resultado[5].toString() : null, // asunto
                resultado[6] != null ? resultado[6].toString() : null, // empleado
                identificacionUrl, // identificacion (URL firmada)
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
                fotoUrl, // foto (URL firmada)
                firmaUrl, // firmaVisitante (URL firmada)
                identificacion2Url, // identificacion2 (URL firmada)
                resultado[21] != null ? resultado[21].toString() : null, // compania
                resultado[22] instanceof Number ? ((Number) resultado[22]).intValue() : null // completado
        );
    }

    private String firmarUrl(String url, String folder) {
        if (url == null || url.isEmpty()) {
            return null;
        }

        try {
            // Extrae el nombre del archivo de la URL
            String[] partes = url.split("/");
            String fileNameWithExtension = partes[partes.length - 1]; // Nombre del archivo con extensión
            String fileName = fileNameWithExtension.split("\\.")[0]; // Nombre del archivo sin extensión

            // Genera la URL firmada
            return s3Service.generarUrlFirmada(folder, fileName);
        } catch (Exception e) {
            e.printStackTrace();
            // Si ocurre un error, usa la URL original
            return url;
        }
    }

}