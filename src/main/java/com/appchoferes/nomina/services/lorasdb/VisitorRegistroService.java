package com.appchoferes.nomina.services.lorasdb;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appchoferes.nomina.models.lorasdb.Vehiculo;
import com.appchoferes.nomina.models.lorasdb.VisitorVisitante;
import com.appchoferes.nomina.models.lorasdb.dtos.EmpleadoVisitaDTO;
import com.appchoferes.nomina.models.lorasdb.dtos.VehiculoDTO;
import com.appchoferes.nomina.models.lorasdb.dtos.VisitanteDTO;
import com.appchoferes.nomina.repositories.lorasdb.VehiculoRepo;
import com.appchoferes.nomina.repositories.lorasdb.VisitorVisitanteRepo;
import com.appchoferes.nomina.utils.ImageUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Service
public class VisitorRegistroService {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private VisitorVisitanteRepo visitanteRepo;

    @Autowired
    private VehiculoRepo vehiculoRepo;

    public static final String BASE_DIRECTORY = "/home/drago/work/lorasImagenes/visitantes/";

    @Transactional
    public void saveVisit(EmpleadoVisitaDTO empleado, List<VisitanteDTO> visitanteDTOs, VehiculoDTO vehiculoDTO) {

        for (VisitanteDTO visitante : visitanteDTOs) {
            Long count = (Long) entityManager.createQuery(
                    "SELECT COUNT(v) FROM VisitorRegistro v WHERE v.visitanteId = :visitanteId AND v.salida IS NULL")
                    .setParameter("visitanteId", visitante.getId())
                    .getSingleResult();

            if (count == 0) {

                String vehiculoInfo = (vehiculoDTO.getModelo() != null)
                        ? vehiculoDTO.getModelo() + "[" + vehiculoDTO.getAnio() + "]/" + vehiculoDTO.getPlacas()
                        : null;

                entityManager
                        .createNativeQuery(
                                """
                                            INSERT INTO visitor_registros (visitanteID, entrada, nombre, empresa, empresaID, asunto, empleado, gafete, gafeteID, vehiculo, fecha)
                                            VALUES (:visitanteID, :entrada, :nombre, :empresa, :empresaID, :asunto, :empleado, :gafete, :gafeteID, :vehiculo, :fecha)
                                        """)
                        .setParameter("visitanteID", visitante.getId())
                        .setParameter("entrada", LocalDateTime.now())
                        .setParameter("nombre", visitante.getNombre())
                        .setParameter("empresa", visitante.getEmpresa())
                        .setParameter("empresaID", visitante.getEmpresaID())
                        .setParameter("asunto", empleado.getAsunto())
                        .setParameter("empleado", empleado.getNombre())
                        .setParameter("gafete", visitante.getTipo() + "-" +
                                ((visitante.getGafeteNombre() != null && visitante.getGafeteNombre().length() > 10)
                                        ? "0"
                                        : "")
                                +
                                (visitante.getGafeteNombre() != null ? visitante.getGafeteNombre() : ""))
                        .setParameter("gafeteID", visitante.getGafete())
                        .setParameter("vehiculo", vehiculoInfo)
                        .setParameter("fecha", LocalDateTime.now())
                        .executeUpdate();

                entityManager.createNativeQuery("""
                            UPDATE visitor_gafetes
                            SET visitante = :visitanteID
                            WHERE id = :gafeteID
                        """)
                        .setParameter("visitanteID", visitante.getId())
                        .setParameter("gafeteID", visitante.getGafete())
                        .executeUpdate();

            }
        }
    }

    @Transactional
    public Long saveVisitanteAndVehiculo(VisitorVisitante visitante, Vehiculo vehiculo) throws Exception {
        // Procesar imágenes antes de guardar
        if (visitante.getFoto() != null) {
            String path = ImageUtil.saveImage(visitante.getFoto(), "Foto", BASE_DIRECTORY + "fotos/");
            visitante.setFoto(path);
        }

        if (visitante.getFirma() != null) {
            byte[] firmaBytes = Base64.getDecoder().decode(visitante.getFirma());
            visitante.setFirma(firmaBytes);
        }

        if (visitante.getIdentificacion() != null) {
            String path = ImageUtil.saveImage(visitante.getIdentificacion(), "Identificacion",
                    BASE_DIRECTORY + "identificaciones/");
            visitante.setIdentificacion(path);
        }

        if (visitante.getIdentificacion2() != null) {
            String path = ImageUtil.saveImage(visitante.getIdentificacion2(), "Identificacion2",
                    BASE_DIRECTORY + "identificaciones/");
            visitante.setIdentificacion2(path);
        }

        // Guarda el visitante en la base de datos
        visitante = visitanteRepo.save(visitante);

        // Guarda el vehículo asociado
        vehiculo.setVisitante(visitante.getId().intValue());
        vehiculoRepo.save(vehiculo);

        return visitante.getId();
    }

    public byte[] getImage(Long id, String tipo) throws IOException {
        // Construir la ruta del archivo
        Path path = Paths.get(BASE_DIRECTORY + tipo + "/" + id + ".jpg");

        if (!Files.exists(path)) {
            throw new IOException("Imagen no encontrada: " + path);
        }

        return Files.readAllBytes(path);
    }

}
