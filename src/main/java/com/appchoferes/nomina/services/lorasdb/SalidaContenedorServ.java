package com.appchoferes.nomina.services.lorasdb;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appchoferes.nomina.models.lorasdb.InventarioExternoInspeccion;
import com.appchoferes.nomina.models.lorasdb.P_InventarioExterno;
import com.appchoferes.nomina.repositories.lorasdb.InventarioExternoInspeccionRepository;
import com.appchoferes.nomina.repositories.lorasdb.InventarioExternoRepository;
import com.appchoferes.nomina.utils.ImageUtil;

@Service
public class SalidaContenedorServ {

    @Autowired
    private InventarioExternoRepository inventarioExternoRepository;

    @Autowired
    private InventarioExternoInspeccionRepository inventarioExternoInspeccionRepository;

    private static final String BASE_DIRECTORY = "/home/drago/work/lorasImagenes/salidas/";

    public P_InventarioExterno saveSalidaInventario(P_InventarioExterno contenedor,
            List<InventarioExternoInspeccion> puntos) {

        try {
            if (contenedor.getFirmak9() != null) {
                String path = ImageUtil.saveImage(contenedor.getFirmak9(), "firmak9_" + contenedor.getInventarioID(),
                        BASE_DIRECTORY + "firmas/");
                contenedor.setFirmak9(path);
            }

        } catch (Exception e) {
            throw new RuntimeException("Error al guardar las imágenes", e);
        }

        P_InventarioExterno saveSalida = inventarioExternoRepository.save(contenedor);
        for (InventarioExternoInspeccion punto : puntos) {
            punto.setInventarioID(saveSalida.getInventarioID());
            punto.setEntrada(false);

            if (punto.getFotosalida() != null) {
                String path;
                try {
                    path = ImageUtil.saveImage(punto.getFotosalida(), "inspeccionSalida_" + punto.getListadoID(),
                            BASE_DIRECTORY + "puntosSalida/");
                    punto.setFotosalida(path);
                } catch (Exception e) {
                    throw new RuntimeException("Error al guardar la imagen de salida", e);
                }
            }
        }

        inventarioExternoInspeccionRepository.saveAll(puntos);
        return saveSalida;

    }

}