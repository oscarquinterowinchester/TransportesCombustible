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
public class InventarioExternoService {

    @Autowired
    private InventarioExternoRepository inventarioExternoRepository;

    @Autowired
    private InventarioExternoInspeccionRepository inventarioExternoInspeccionRepository;

    public static final String BASE_DIRECTORY = "/home/drago/work/lorasImagenes/entradas/";

    public P_InventarioExterno saveInventario(P_InventarioExterno inventario,
            List<InventarioExternoInspeccion> puntos) {
        try {
            if (inventario.getFotoSello() != null) {
                String path = ImageUtil.saveImage(inventario.getFotoSello(), "selloEntrada",
                        BASE_DIRECTORY + "sellosEntrada/");
                inventario.setFotoSello(path);
            }
            if (inventario.getFirmaGuardia() != null) {
                String path = ImageUtil.saveImage(inventario.getFirmaGuardia(), "guardia",
                        BASE_DIRECTORY + "firmasEntrada/");
                inventario.setFirmaGuardia(path);
            }
            if (inventario.getFirmaChofer() != null) {
                String path = ImageUtil.saveImage(inventario.getFirmaChofer(), "chofer",
                        BASE_DIRECTORY + "firmasEntrada/");
                inventario.setFirmaChofer(path);
            }
            if (inventario.getFirmak9() != null) {
                String path = ImageUtil.saveImage(inventario.getFirmak9(), "k9",
                        BASE_DIRECTORY + "firmasEntrada/");
                inventario.setFirmak9(path);
            }
        } catch (Exception e) {
            throw new RuntimeException("Error al guardar las imágenes", e);
        }

        P_InventarioExterno savedInventario = inventarioExternoRepository.save(inventario);
        for (InventarioExternoInspeccion punto : puntos) {
            punto.setInventarioID(savedInventario.getInventarioID());

            if (punto.getFotoentrada() != null) {
                String path;
                try {
                    path = ImageUtil.saveImage(punto.getFotoentrada(), "inspeccion_" + punto.getListadoID(),
                            BASE_DIRECTORY + "puntosEntrada/");
                    punto.setFotoentrada(path);
                } catch (Exception e) {
                    throw new RuntimeException("Error al guardar imagenes de entrada", e);
                }

            }
        }

        inventarioExternoInspeccionRepository.saveAll(puntos);
        return savedInventario;
    }

    public boolean esEntradaDuplicada(String contenedor, Integer itinerarioId) {
        Integer tipoEvento = 1;
        List<Integer> entradas = inventarioExternoRepository.findEntrada(contenedor, tipoEvento);

        return entradas != null; // No encontro ninguna entrada duplicada
    }

}
