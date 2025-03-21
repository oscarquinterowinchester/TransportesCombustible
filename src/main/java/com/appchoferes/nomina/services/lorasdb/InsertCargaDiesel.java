package com.appchoferes.nomina.services.lorasdb;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appchoferes.nomina.models.lorasdb.CargaDiesel;
import com.appchoferes.nomina.models.lorasdb.Ticket;
import com.appchoferes.nomina.repositories.lorasdb.CombustibleCargasDieselRepository;
import com.appchoferes.nomina.repositories.lorasdb.TicketRepository;
import com.appchoferes.nomina.utils.S3Service;

import jakarta.transaction.Transactional;

@Service
public class InsertCargaDiesel {

    @Autowired
    private CombustibleCargasDieselRepository combustibleCargasDieselRepository;

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private S3Service s3Service; // Inyecta el servicio de S3

    private static final Map<String, String> CARPETAS_IMG = Map.of(
            "fotoTanque1", "/tanques",
            "fotoTanque2", "/tanques",
            "fotoOdometro", "/odometros",
            "firma", "/firmas",
            "fotoSello", "/sellos");

    @Transactional
    public CargaDiesel insertaCargaDiesel(CargaDiesel cargaDiesel) throws Exception {
        // guarda las imagenes en variables temporales
        Map<String, String> imagenesBase64 = extraerImagenesBase64(cargaDiesel);

        // quitamos las imagenes del objeto para realizar la insercion sin ellas
        limpiarImagenes(cargaDiesel);

        // hace la insecion de la carga sin las imagenes y obtiene su id
        CargaDiesel saveCargaDiesel = combustibleCargasDieselRepository.save(cargaDiesel);

        // sube las imagenes al S3 y obtiene las rutas
        Map<String, String> rutasImagenes = subirImagenesAS3(saveCargaDiesel.getCargaId(), imagenesBase64);

        // actualiza las rutas de las imagenes en la base de datos
        actualizarRutasEnBaseDeDatos(saveCargaDiesel.getCargaId(), rutasImagenes);

        // procesa los tickets asociados al objeto
        procesarTickets(saveCargaDiesel);

        return saveCargaDiesel;
    }

    private Map<String, String> extraerImagenesBase64(CargaDiesel cargaDiesel) {
        Map<String, String> imagenes = new HashMap<>();
        imagenes.put("fotoTanque1", cargaDiesel.getFotoTanque1());
        imagenes.put("fotoTanque2", cargaDiesel.getFotoTanque2());
        imagenes.put("fotoOdometro", cargaDiesel.getFotoOdometro());
        imagenes.put("firma", cargaDiesel.getFirma());
        imagenes.put("fotoSello", cargaDiesel.getFotoSello());
        return imagenes;
    }

    private void limpiarImagenes(CargaDiesel cargaDiesel) {
        cargaDiesel.setFotoTanque1(null);
        cargaDiesel.setFotoTanque2(null);
        cargaDiesel.setFotoOdometro(null);
        cargaDiesel.setFirma(null);
        cargaDiesel.setFotoSello(null);
    }

    private Map<String, String> subirImagenesAS3(Long cargaId, Map<String, String> imagenesBase64) {
        Map<String, String> rutasImagenes = new HashMap<>();
        imagenesBase64.forEach((key, value) -> {
            if (value != null) {
                // Obtiene la carptea especifica para cada tipo de imagen
                String carpeta = CARPETAS_IMG.get(key);
                String ruta;
                try {
                    // sube la imagen a la carpeta correspondinete
                    ruta = s3Service.uploadFile("patios/carga" + carpeta, key, String.valueOf(cargaId), value);
                    rutasImagenes.put(key, ruta);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        return rutasImagenes;
    }

    private void actualizarRutasEnBaseDeDatos(Long cargaId, Map<String, String> rutasImagenes) {
        combustibleCargasDieselRepository.actualizarImagenes(cargaId,
                rutasImagenes.get("fotoTanque1"),
                rutasImagenes.get("fotoTanque2"),
                rutasImagenes.get("firma"),
                rutasImagenes.get("fotoOdometro"),
                rutasImagenes.get("fotoSello"));
    }

    private void procesarTickets(CargaDiesel cargaDiesel) {
        if (cargaDiesel.getTickets() != null && !cargaDiesel.getTickets().isEmpty()) {
            cargaDiesel.getTickets().forEach(ticketBase64 -> {
                Ticket ticket = new Ticket();
                // los tickets se guardan en la carpeta "tickets"
                String path;
                try {
                    path = s3Service.uploadFile("patios/carga/tickets", "ticket",
                            String.valueOf(cargaDiesel.getCargaId()), ticketBase64);
                    ticket.setFoto(path);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                ticket.setCargaID(cargaDiesel.getCargaId());
                ticketRepository.save(ticket);
            });
        }
    }


}
