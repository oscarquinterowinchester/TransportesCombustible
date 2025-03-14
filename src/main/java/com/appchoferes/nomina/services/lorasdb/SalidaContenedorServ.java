package com.appchoferes.nomina.services.lorasdb;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appchoferes.nomina.models.lorasdb.InventarioExternoInspeccion;
import com.appchoferes.nomina.models.lorasdb.P_InventarioExterno;
import com.appchoferes.nomina.repositories.lorasdb.InventarioExternoInspeccionRepository;
import com.appchoferes.nomina.repositories.lorasdb.InventarioExternoRepository;
import com.appchoferes.nomina.utils.S3Service;

import jakarta.transaction.Transactional;

@Service
public class SalidaContenedorServ {

    @Autowired
    private InventarioExternoRepository inventarioExternoRepository;

    @Autowired
    private InventarioExternoInspeccionRepository inventarioExternoInspeccionRepository;

    @Autowired
    private S3Service s3Service;

    @Transactional
    public P_InventarioExterno saveSalidaInventario(P_InventarioExterno contenedor,
            List<InventarioExternoInspeccion> puntos) throws Exception {
        // Establece el tipo de evento como salida
        contenedor.setTipoEvento(2);

        // Guarda el inventario en la base de datos (sin la firma k9)
        P_InventarioExterno savedInventario = inventarioExternoRepository.save(contenedor);

        // Sube la firma k9 a S3 y actualiza el inventario en la base de datos
        if (contenedor.getFirmak9() != null) {
            String path = subirFirmak9AS3(savedInventario.getInventarioID(), contenedor.getFirmak9());
            savedInventario.setFirmak9(path);
            inventarioExternoRepository.save(savedInventario); // Actualiza el inventario con la ruta de la firma k9
        }

        // Procesa los puntos de inspección
        procesarPuntosInspeccionSalida(puntos, savedInventario.getInventarioID());

        return savedInventario;
    }

    private String subirFirmak9AS3(Integer inventarioID, String firmak9Base64) throws IOException {
        return s3Service.uploadFile("patios/salidas/firmas", "firmak9", inventarioID.toString(), firmak9Base64);
    }

    private void procesarPuntosInspeccionSalida(List<InventarioExternoInspeccion> puntos, Integer inventarioID) {
        puntos.forEach(punto -> {
            punto.setInventarioSalidaID(inventarioID);

            if (punto.getFotosalida() != null) {
                try {
                    String path = s3Service.uploadFile("patios/salidas/inspeccionSalida", "fotosalida",
                            punto.getId() + "_" + inventarioID, punto.getFotosalida());
                    punto.setFotosalida(path);
                } catch (IOException e) {
                    throw new RuntimeException("Error al subir la imagen de salida", e);
                }
            }

            // Actualiza la inspección en la base de datos
            inventarioExternoInspeccionRepository.actualizarInspeccionSalida(
                    punto.getId(),
                    punto.getInventarioSalidaID(),
                    punto.getSalida(),
                    punto.getFechaSalida() != null ? punto.getFechaSalida() : LocalDateTime.now(),
                    punto.getComentariosalida() != null ? punto.getComentariosalida() : "",
                    punto.getFotosalida() != null ? punto.getFotosalida() : "");
        });
    }

}
