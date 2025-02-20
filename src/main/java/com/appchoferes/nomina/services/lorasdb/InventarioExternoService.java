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

    public P_InventarioExterno saveInventarioEntrada(P_InventarioExterno inventario,
            List<InventarioExternoInspeccion> puntos) {
        try {
            if (inventario.getFotoSello() != null) {
                String path = ImageUtil.saveImage(inventario.getFotoSello(), "selloEntrada",
                        inventario.getInventarioID().toString(),
                        BASE_DIRECTORY + "sellosEntrada/");
                inventario.setFotoSello(path);
            }
            if (inventario.getFirmaGuardia() != null) {
                String path = ImageUtil.saveImage(inventario.getFirmaGuardia(), "guardia",
                        inventario.getInventarioID().toString(),
                        BASE_DIRECTORY + "firmasEntrada/");
                inventario.setFirmaGuardia(path);
            }
            if (inventario.getFirmaChofer() != null) {
                String path = ImageUtil.saveImage(inventario.getFirmaChofer(), "chofer",
                        inventario.getInventarioID().toString(),
                        BASE_DIRECTORY + "firmasEntrada/");
                inventario.setFirmaChofer(path);
            }
            if (inventario.getFirmak9() != null) {
                String path = ImageUtil.saveImage(inventario.getFirmak9(), "k9",
                        inventario.getInventarioID().toString(),
                        BASE_DIRECTORY + "firmasEntrada/");
                inventario.setFirmak9(path);
            }
        } catch (Exception e) {
            throw new RuntimeException("Error al guardar las imágenes", e);
        }

        // tipoEvento = 1, para decir que es una entrada
        inventario.setTipoEvento(1);
        P_InventarioExterno savedInventario = inventarioExternoRepository.save(inventario);
        for (InventarioExternoInspeccion punto : puntos) {
            punto.setInventarioID(savedInventario.getInventarioID());

            if (punto.getFotoentrada() != null) {
                String path;
                try {
                    path = ImageUtil.saveImage(punto.getFotoentrada(), "inspeccion", punto.getListadoID().toString(),
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
        List<Integer> entradas = inventarioExternoRepository.findEntrada(contenedor);
        System.out.println("Entradas encontradas: " + entradas);
        return entradas != null && !entradas.isEmpty(); // No encontro ninguna entrada duplicada
    }

}
