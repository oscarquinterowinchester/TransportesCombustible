package com.appchoferes.nomina.services.lorasdb;

import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Service;

import com.appchoferes.nomina.models.lorasdb.dtos.ContenedorEntradaDTO;
import com.appchoferes.nomina.models.lorasdb.dtos.PuntosInspeccionEntradaDTO;
import com.appchoferes.nomina.utils.ImageUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Service
public class InventarioExternoServ {

    @PersistenceContext
    private EntityManager entityManager;

    public static final String BASE_DIRECTORY = "/home/drago/work/lorasImagenes/entradas/";

    @Transactional
    public void procesarInventarioExterno(ContenedorEntradaDTO contenedor) {
        try {
            // Validar si hay entrada duplicada
            if (esEntradaDuplicada(contenedor.getContenedor(), contenedor.getItinerarioID())) {
                throw new IllegalArgumentException("Entrada duplicada");
            }

            // Procesar imágenes antes de guardar
            procesarImagenes(contenedor);

            // **Insertar en la tabla `inventarioexterno_tbl`**
            entityManager.createNativeQuery("""
                        INSERT INTO inventarioexterno_tbl (Contenedor, ItinerarioID, PlacasUnidad, Sello,
                        PaisID, EstadoID, ChoferID, RutaID, UsuarioID, ClienteID, TipoEvento, FechaEvento,
                        PatioID, Tamano, Firmak9, camion, Carrier, FotoSello, FirmaGuardia, FirmaChofer,
                        UsuarioEventoID, EstadoCarga, Botando)
                        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
                    """)
                    .setParameter(1, safeValue(contenedor.getContenedor()))
                    .setParameter(2, safeValue(contenedor.getItinerarioID()))
                    .setParameter(3, safeValue(contenedor.getPlacasUnidad()))
                    .setParameter(4, safeValue(contenedor.getSello()))
                    .setParameter(5, safeValue(contenedor.getPaisID()))
                    .setParameter(6, safeValue(contenedor.getEstadoID()))
                    .setParameter(7, safeValue(contenedor.getChoferID()))
                    .setParameter(8, safeValue(contenedor.getRutaID()))
                    .setParameter(9, safeValue(contenedor.getUsuarioID()))
                    .setParameter(10, safeValue(contenedor.getClienteID()))
                    .setParameter(11, 1) // TipoEvento siempre 1
                    .setParameter(12, safeValue(contenedor.getFechaEvento()))
                    .setParameter(13, safeValue(contenedor.getPatioID()))
                    .setParameter(14, safeValue(contenedor.getTamano()))
                    .setParameter(15, safeValue(contenedor.getFirmak9()))
                    .setParameter(16, safeValue(contenedor.getCamion()))
                    .setParameter(17, safeValue(contenedor.getCarrier()))
                    .setParameter(18, safeValue(contenedor.getFotoSello()))
                    .setParameter(19, safeValue(contenedor.getFirmaGuardia()))
                    .setParameter(20, safeValue(contenedor.getFirmaChofer()))
                    .setParameter(21, safeValue(contenedor.getUsuarioEventoID()))
                    .setParameter(22, safeValue(contenedor.getEstadoCarga()))
                    .setParameter(23, safeValue(contenedor.getBotando()))
                    .executeUpdate();

            // 🔹 **Obtener el último ID insertado**
            Long InventarioID = ((Number) entityManager.createNativeQuery("SELECT LAST_INSERT_ID()").getSingleResult())
                    .longValue();

            if (InventarioID == null) {
                throw new RuntimeException("Error al obtener el InventarioID.");
            }

            // 🔹 **Insertar puntos de inspección**
            procesarPuntosInspeccion(contenedor.getPuntos(), InventarioID);

            // 🔹 **Forzar sincronización con la base de datos**
            entityManager.flush();

        } catch (Exception e) {
            throw new RuntimeException("Error al insertar contenedor: " + e.getMessage(), e);
        }
    }

    private void procesarImagenes(ContenedorEntradaDTO contenedor) {
        try {
            if (contenedor.getFotoSello() != null && !contenedor.getFotoSello().isEmpty()) {
                contenedor.setFotoSello(ImageUtil.saveImage(contenedor.getFotoSello(),
                        contenedor.getContenedor() + "_sello", BASE_DIRECTORY + "sellosEntrada/"));
            }
            if (contenedor.getFirmak9() != null && !contenedor.getFirmak9().isEmpty()) {
                contenedor.setFirmak9(ImageUtil.saveImage(contenedor.getFirmak9(),
                        contenedor.getContenedor() + "_firmak9", BASE_DIRECTORY + "firmasEntrada/"));
            }
            if (contenedor.getFirmaChofer() != null && !contenedor.getFirmaChofer().isEmpty()) {
                contenedor.setFirmaChofer(ImageUtil.saveImage(contenedor.getFirmaChofer(),
                        contenedor.getContenedor() + "_firmaChofer", BASE_DIRECTORY + "firmasEntrada/"));
            }
            if (contenedor.getFirmaGuardia() != null && !contenedor.getFirmaGuardia().isEmpty()) {
                contenedor.setFirmaGuardia(ImageUtil.saveImage(contenedor.getFirmaGuardia(),
                        contenedor.getContenedor() + "_firmaGuardia", BASE_DIRECTORY + "firmasEntrada/"));
            }
        } catch (Exception e) {
            throw new RuntimeException("Error al procesar imágenes: " + e.getMessage());
        }
    }

    private boolean esEntradaDuplicada(String contenedor, Integer itinerarioId) {
        String sql = "SELECT COUNT(*) FROM inventarioexterno_tbl WHERE Contenedor = ? AND ItinerarioID = ? AND status = true";
        Integer count = ((Number) entityManager.createNativeQuery(sql)
                .setParameter(1, contenedor)
                .setParameter(2, itinerarioId)
                .getSingleResult()).intValue();
        return count > 0;
    }

    private void procesarPuntosInspeccion(List<PuntosInspeccionEntradaDTO> puntos, Long InventarioID) {
        if (puntos == null || puntos.isEmpty()) {
            return;
        }

        for (PuntosInspeccionEntradaDTO punto : puntos) {
            if (punto == null || punto.getNombre() == null)
                continue;

            String imagenPath = null;
            if (punto.getFotoEntrada() != null && !punto.getFotoEntrada().isEmpty()) {
                try {
                    imagenPath = ImageUtil.saveImage(punto.getFotoEntrada(),
                            punto.getNombre() + "_entrada", BASE_DIRECTORY + "puntosEntrada/");
                } catch (Exception e) {
                    System.err.println("Error al guardar la imagen: " + e.getMessage());
                }
            }

            entityManager
                    .createNativeQuery(
                            """
                                        INSERT INTO inventarioexternoinspecciones_tbl (InventarioID, ListadoID, fotoentrada, comentarioentrada)
                                        VALUES (?, ?, ?, ?)
                                    """)
                    .setParameter(1, InventarioID)
                    .setParameter(2, punto.getListadoID())
                    .setParameter(3, imagenPath)
                    .setParameter(4, Objects.requireNonNullElse(punto.getComentarioEntrada(), ""))
                    .executeUpdate();
        }
    }

    private <T> T safeValue(T value) {
        return value != null ? value : (T) (value instanceof String ? "" : null);
    }
}
