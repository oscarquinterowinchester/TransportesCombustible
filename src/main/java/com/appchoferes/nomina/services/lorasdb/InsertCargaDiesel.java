package com.appchoferes.nomina.services.lorasdb;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appchoferes.nomina.models.lorasdb.CargaDiesel;
import com.appchoferes.nomina.models.lorasdb.Ticket;
import com.appchoferes.nomina.repositories.lorasdb.CombustibleCargasDieselRepository;
import com.appchoferes.nomina.repositories.lorasdb.TicketRepository;
import com.appchoferes.nomina.utils.ImageUtil;

@Service
public class InsertCargaDiesel {

    @Autowired
    private CombustibleCargasDieselRepository combustibleCargasDieselRepository;

    @Autowired
    private TicketRepository ticketRepository;

    public static final String BASE_DIRECTORY = "C:" + File.separator + "TransportesMultiConexion" + File.separator
            + "imagenes" + File.separator;

    public CargaDiesel insertarCargaDiesel(CargaDiesel cargaDiesel) throws Exception {

        // Procesamos las imagenes antes de guardarlas
        if (cargaDiesel.getFotoTanque1() != null) {
            String path = ImageUtil.saveImage(cargaDiesel.getFotoTanque1(), "FotoTanque1",
                    cargaDiesel.getUnidadID().toString(),
                    BASE_DIRECTORY + "tanques" + File.separator);
            cargaDiesel.setFotoTanque1(path);
        }

        if (cargaDiesel.getFotoTanque2() != null) {
            String path = ImageUtil.saveImage(cargaDiesel.getFotoTanque2(), "FotoTanque2",
                    cargaDiesel.getUnidadID().toString(),
                    BASE_DIRECTORY + "tanques" + File.separator);
            cargaDiesel.setFotoTanque2(path);
        }

        if (cargaDiesel.getFirma() != null) {
            String path = ImageUtil.saveImage(cargaDiesel.getFirma(), "Firma", cargaDiesel.getUsuarioID().toString(),
                    BASE_DIRECTORY + "firmas" + File.separator);
            cargaDiesel.setFirma(path);
        }

        if (cargaDiesel.getFotoOdometro() != null) {
            String path = ImageUtil.saveImage(cargaDiesel.getFotoOdometro(), "Odometro",
                    cargaDiesel.getUnidadID().toString(), BASE_DIRECTORY + "odometros" + File.separator);
            cargaDiesel.setFotoOdometro(path);
        }

        if (cargaDiesel.getFotoSello() != null) {
            String path = ImageUtil.saveImage(cargaDiesel.getFotoSello(), "Sello", cargaDiesel.getUnidadID().toString(),
                    BASE_DIRECTORY + "sellos" + File.separator);
            cargaDiesel.setFotoSello(path);
        }

        // Guarda carga principal
        CargaDiesel saveCargaDiesel = combustibleCargasDieselRepository.save(cargaDiesel);

        // Inserta los tickets asociados
        if (cargaDiesel.getTickets() != null && !cargaDiesel.getTickets().isEmpty()) {
            // Recibe la imagen en Base64
            for (String ticketBase64 : cargaDiesel.getTickets()) {
                Ticket ticket = new Ticket();

                String path = ImageUtil.saveImage(ticketBase64, "Ticket", cargaDiesel.getUnidadID().toString(),
                        BASE_DIRECTORY + "tickets" + File.separator);
                ticket.setFoto(path);

                ticket.setCargaID(cargaDiesel.getCargaId());
                ticketRepository.save(ticket);
            }
        }

        return saveCargaDiesel;
    }

}
