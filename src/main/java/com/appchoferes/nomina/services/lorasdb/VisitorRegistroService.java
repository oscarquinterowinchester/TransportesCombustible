package com.appchoferes.nomina.services.lorasdb;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appchoferes.nomina.models.lorasdb.Vehiculo;
import com.appchoferes.nomina.models.lorasdb.VisitorVisitante;
import com.appchoferes.nomina.models.lorasdb.dtos.EmpleadoVisitaDTO;
import com.appchoferes.nomina.models.lorasdb.dtos.VehiculoDTO;
import com.appchoferes.nomina.models.lorasdb.dtos.VisitanteDTO;
import com.appchoferes.nomina.models.lorasdb.dtos.VisitanteVehiculoRequest;
import com.appchoferes.nomina.repositories.lorasdb.VehiculoRepo;
import com.appchoferes.nomina.repositories.lorasdb.VisitorVisitanteRepo;
import com.appchoferes.nomina.utils.S3Service;

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

    @Autowired
    private S3Service s3Service;

    private static final Map<String, String> CARPETAS_IMG = Map.of(
            "foto", "/fotos",
            "firma", "/firmas",
            "identificacion1", "/identificaciones",
            "identificacion2", "/identificaciones");

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
    public Long saveVisitantesAndVehiculo(VisitanteVehiculoRequest request) throws Exception {
        // Extraer datos del request
        VisitorVisitante visitante = request.getVisitante();
        Vehiculo vehiculo = request.getVehiculo();

        // Extraer imágenes en Base64 una sola vez
        Map<String, String> imagenesBase64 = extraerImagenesVisitante(visitante);

        // Guardar visitante sin imágenes
        Long idVisitante = guardarVisitanteSinImagenes(visitante);

        // Subir imágenes y actualizar visitante
        subirYActualizarImagenesVisitante(imagenesBase64, idVisitante);

        // Guardar vehículo asociado al visitante
        guardarVehiculo(vehiculo, idVisitante);

        return idVisitante;
    }

    private Long guardarVisitanteSinImagenes(VisitorVisitante visitante) {
        // Establecer la fecha actual
        visitante.setFecha(LocalDateTime.now());

        // Limpiar imágenes del objeto para no guardarlas en la base de datos
        limpiarImagenesVisitante(visitante);

        // Guardar visitante en la base de datos (sin imágenes)
        visitante = visitanteRepo.save(visitante);
        return visitante.getId();
    }

    private Map<String, String> extraerImagenesVisitante(VisitorVisitante visitante) {
        Map<String, String> imagenes = new HashMap<>();
        imagenes.put("foto", visitante.getFoto());
        imagenes.put("firma", visitante.getFirma());
        imagenes.put("identificacion1", visitante.getIdentificacion());
        imagenes.put("identificacion2", visitante.getIdentificacion2());
        return imagenes;
    }

    private void limpiarImagenesVisitante(VisitorVisitante visitante) {
        visitante.setFoto(null);
        visitante.setFirma(null);
        visitante.setIdentificacion(null);
        visitante.setIdentificacion2(null);
    }

    private void subirYActualizarImagenesVisitante(Map<String, String> imagenesBase64, Long idVisitante) {
        // Subir imágenes a S3 y obtener las rutas
        Map<String, String> rutasImagenes = subirImagenesAS3(idVisitante, imagenesBase64);

        // Actualizar las rutas de las imágenes en la base de datos
        actualizarRutasEnBaseDeDatos(idVisitante, rutasImagenes);
    }

    private Map<String, String> subirImagenesAS3(Long idVisitante, Map<String, String> imagenesBase64) {
        Map<String, String> rutasImagenes = new HashMap<>();
        imagenesBase64.forEach((key, value) -> {
            if (value != null) {
                // Obtiene la carpeta específica para cada tipo de imagen
                String carpeta = CARPETAS_IMG.get(key);
                String ruta;
                try {
                    // Sube la imagen a la carpeta correspondiente
                    ruta = s3Service.uploadFile("visitantes" + carpeta, key, String.valueOf(idVisitante), value);
                    rutasImagenes.put(key, ruta);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        return rutasImagenes;
    }

    private void actualizarRutasEnBaseDeDatos(Long idVisitante, Map<String, String> rutasImagenes) {
        visitanteRepo.updateFoto(rutasImagenes.get("foto"), idVisitante);
        visitanteRepo.updateFirma(rutasImagenes.get("firma"), idVisitante);
        visitanteRepo.updateIdentificacion(rutasImagenes.get("identificacion1"), idVisitante);
        visitanteRepo.updateIdentificacion2(rutasImagenes.get("identificacion2"), idVisitante);
    }

    private void guardarVehiculo(Vehiculo vehiculo, Long idVisitante) {
        vehiculo.setVisitante(idVisitante.intValue());
        vehiculoRepo.save(vehiculo);
    }

}
