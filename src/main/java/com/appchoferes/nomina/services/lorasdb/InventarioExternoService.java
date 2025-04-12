package com.appchoferes.nomina.services.lorasdb;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appchoferes.nomina.models.lorasdb.InventarioExternoInspeccion;
import com.appchoferes.nomina.models.lorasdb.P_InventarioExterno;
import com.appchoferes.nomina.repositories.lorasdb.InventarioExternoInspeccionRepository;
import com.appchoferes.nomina.repositories.lorasdb.InventarioExternoRepository;
import com.appchoferes.nomina.utils.S3Service;

@Service
public class InventarioExternoService {

    @Autowired
    private InventarioExternoRepository inventarioExternoRepository;

    @Autowired
    private InventarioExternoInspeccionRepository inventarioExternoInspeccionRepository;

    @Autowired
    private S3Service s3Service;

    private static final Map<String, String> CARPETAS_IMG = Map.of(
            //"fotoSello", "/sellos",
            "firmaGuardia", "/firmas",
            "firmaChofer", "/firmas",
            "firmak9", "/firmas");

    public P_InventarioExterno saveInventarioEntrada(P_InventarioExterno inventario,
            List<InventarioExternoInspeccion> puntos) throws Exception {

        Map<String, String> imagenesBase64 = extraerImagenesBase64(inventario);

        limpiarImagenes(inventario);

        // establecemos el tipo de evento como entrada
        inventario.setTipoEvento(1);

        // guarda inventario en la base de datos sin imagenes
        P_InventarioExterno saveInventario = inventarioExternoRepository.save(inventario);

        // sube las imagenes a S3 y obtiene las rutas
        Map<String, String> rutasImagenes = subirImagenesAS3(saveInventario.getInventarioID(), imagenesBase64);

        // actualiza los campos de la base de datos con las rutas de S3
        actualizarRutasEnLaBaseDeDatos(inventario.getInventarioID(), rutasImagenes);

        procesarPuntosInspeccion(puntos, saveInventario.getInventarioID());

        return inventario;

    }

    private Map<String, String> extraerImagenesBase64(P_InventarioExterno inventario) {
        Map<String, String> imagenes = new HashMap<>();
        //imagenes.put("fotoSello", inventario.getFotoSello());
        imagenes.put("firmaGuardia", inventario.getFirmaGuardia());
        imagenes.put("firmaChofer", inventario.getFirmaChofer());
        imagenes.put("firmak9", inventario.getFirmak9());
        return imagenes;
    }

    private void limpiarImagenes(P_InventarioExterno inventario) {
        inventario.setFotoSello(null);
        inventario.setFirmaGuardia(null);
        inventario.setFirmaChofer(null);
        inventario.setFirmak9(null);
    }

    private Map<String, String> subirImagenesAS3(Integer inventarioId, Map<String, String> imagenesBase64) {
        Map<String, String> rutasImagenes = new HashMap<>();
        imagenesBase64.forEach((key, value) -> {
            if (value != null) {
                String carpeta = CARPETAS_IMG.get(key);
                String ruta;
                try {
                    ruta = s3Service.uploadFile("patios/entradas" + carpeta, key, String.valueOf(inventarioId), value);
                    rutasImagenes.put(key, ruta);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        return rutasImagenes;
    }

    private void actualizarRutasEnLaBaseDeDatos(Integer inventarioId, Map<String, String> rutasImagenes) {
        inventarioExternoRepository.actualizarInventario(
                rutasImagenes.get("fotoSello"),
                rutasImagenes.get("firmaGuardia"),
                rutasImagenes.get("firmaChofer"),
                rutasImagenes.get("firmak9"),
                inventarioId);
    }

    private void procesarPuntosInspeccion(List<InventarioExternoInspeccion> puntos, Integer inventarioId) {
        puntos.forEach(punto -> {
            punto.setInventarioID(inventarioId);
            punto.setEntrada(1);

            if (punto.getFotoentrada() != null) {
                String path;
                try {
                    path = s3Service.uploadFile("patios/entradas/inspeccionEntrada", "punto",
                            punto.getListadoID() + "_" + inventarioId.toString(), punto.getFotoentrada());
                    punto.setFotoentrada(path);

                } catch (IOException e) {
                    throw new RuntimeException("Error al subir la imagen de inspeccion", e);
                }
            }
        });

        inventarioExternoInspeccionRepository.saveAll(puntos);
    }

    public boolean esEntradaDuplicada(String contenedor, Integer itinerarioId) {
        List<Integer> entradas = inventarioExternoRepository.findEntrada(contenedor);
        System.out.println("Entradas encontradas: " + entradas);
        return entradas != null && !entradas.isEmpty(); // No encontro ninguna
    }

}
