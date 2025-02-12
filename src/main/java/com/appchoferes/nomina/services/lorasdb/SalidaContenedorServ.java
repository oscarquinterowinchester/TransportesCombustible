package com.appchoferes.nomina.services.lorasdb;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appchoferes.nomina.models.lorasdb.dtos.ContenedorDTO;
import com.appchoferes.nomina.models.lorasdb.dtos.PuntoDTO;
import com.appchoferes.nomina.utils.ImageUtil;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Service
public class SalidaContenedorServ {

    @Autowired
    private EntityManager entityManager;

    private static final String BASE_DIRECTORY = "/home/drago/work/lorasImagenes/";

    @Transactional
    public Integer saveSalidaContenedor(ContenedorDTO contenedorDTO, List<PuntoDTO> puntos) throws Exception {

        // Asignar la fecha actual al contenedor
        contenedorDTO.setFechaEvento(LocalDateTime.now().toString());

        // Guardar contenedor usando SQL nativo
        String insertContenedorSql = """
                    INSERT INTO inventarioexterno_tbl (ItinerarioID, WContenedorID, Contenedor, PlacasChasis, Sello,
                    PaisID, ClienteID, EstadoCarga, TipoEvento, FechaEvento, Camion, Origen, Destino, Carrier)
                    VALUES (:itinerarioID, :wContenedorID, :contenedor, :placasChasis, :sello, :paisID, :clienteID,
                            :estadoCarga, :tipoEvento, :fechaEvento, :camion, :origen, :destino, :carrier)
                """;

        entityManager.createNativeQuery(insertContenedorSql)
                .setParameter("itinerarioID", contenedorDTO.getItinerarioID())
                .setParameter("wContenedorID", contenedorDTO.getWContenedorID())
                .setParameter("contenedor", contenedorDTO.getContenedor())
                .setParameter("placasChasis", contenedorDTO.getPlacasChasis())
                .setParameter("sello", contenedorDTO.getSello())
                .setParameter("paisID", contenedorDTO.getPaisID())
                .setParameter("clienteID", contenedorDTO.getClienteID())
                .setParameter("estadoCarga", contenedorDTO.getEstadoCarga())
                .setParameter("tipoEvento", contenedorDTO.getTipoEvento())
                .setParameter("fechaEvento", contenedorDTO.getFechaEvento())
                .setParameter("camion", contenedorDTO.getCamion())
                .setParameter("origen", contenedorDTO.getOrigen())
                .setParameter("destino", contenedorDTO.getDestino())
                .setParameter("carrier", contenedorDTO.getCarrier())
                .executeUpdate();

        // obtener el InventarioID
        Object idContenedorObject = entityManager.createNativeQuery("SELECT LAST_INSERT_ID()").getSingleResult();
        Integer idContenedor = ((Number) idContenedorObject).intValue();

        // Procesar la imagen del sello
        if (contenedorDTO.getSello() != null && isValidBase64Image(contenedorDTO.getSello())) {
            String path = ImageUtil.saveImage(contenedorDTO.getSello(), idContenedor + "_sello",
                    BASE_DIRECTORY + "selloSalida/");
            contenedorDTO.setSello(path);
        }

        // Guardar los puntos usando SQL nativo
        for (PuntoDTO puntoDTO : puntos) {
            String insertPuntoSql = """
                        INSERT INTO inventarioexternoinspecciones_tbl (InventarioSalidaID, InventarioID, ListadoID, FechaSalida, FotoSalida, ComentarioSalida)
                        VALUES (:inventarioSalidaID, :inventarioID, :listadoID, :fechaSalida, :fotoSalida, :comentarioSalida)
                    """;

            entityManager.createNativeQuery(insertPuntoSql)
                    .setParameter("inventarioSalidaID", idContenedor)
                    .setParameter("inventarioID", idContenedor)
                    .setParameter("listadoID", puntoDTO.getListadoId())
                    .setParameter("fechaSalida", LocalDateTime.now().toString())
                    .setParameter("fotoSalida", puntoDTO.getFotoSalida())
                    .setParameter("comentarioSalida", puntoDTO.getComentarioSalida())
                    .executeUpdate();

            if (puntoDTO.getFotoSalida() != null && !puntoDTO.getFotoSalida().isEmpty()) {
                String filePath = ImageUtil.saveImage(puntoDTO.getFotoSalida(), puntoDTO.getId() + "_fotoSalida",
                        BASE_DIRECTORY + "salidasContenedor/");
                puntoDTO.setFotoSalida(filePath);
            }
        }

        return idContenedor;
    }

    private boolean isValidBase64Image(String base64Str) {
        return base64Str != null && base64Str.startsWith("data:image");
    }
}