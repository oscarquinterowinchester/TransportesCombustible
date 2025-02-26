package com.appchoferes.nomina.services.lorasdb;

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

    public static final String BASE_DIRECTORY = "C:\\TransportesMultiConexion\\imagenes\\";

    public CargaDiesel insertarCargaDiesel(CargaDiesel cargaDiesel) throws Exception {

        // Procesamos las imágenes antes de guardarlas
        if (cargaDiesel.getFotoTanque1() != null) {
            String path = ImageUtil.saveImage(
                    cargaDiesel.getFotoTanque1(),
                    "FotoTanque1",
                    String.valueOf(cargaDiesel.getUnidadID() + "_" + cargaDiesel.getFecha()),
                    BASE_DIRECTORY + "tanques\\");
            cargaDiesel.setFotoTanque1(path);
        }

        if (cargaDiesel.getFotoTanque2() != null) {
            String path = ImageUtil.saveImage(
                    cargaDiesel.getFotoTanque2(),
                    "FotoTanque2",
                    String.valueOf(cargaDiesel.getUnidadID() + "_" + cargaDiesel.getFecha()),
                    BASE_DIRECTORY + "tanques\\");
            cargaDiesel.setFotoTanque2(path);
        }

        if (cargaDiesel.getFirma() != null) {
            String path = ImageUtil.saveImage(
                    cargaDiesel.getFirma(),
                    "Firma",
                    String.valueOf(cargaDiesel.getUnidadID() + "_" + cargaDiesel.getFecha()),
                    BASE_DIRECTORY + "firmas\\");
            cargaDiesel.setFirma(path);
        }

        if (cargaDiesel.getFotoOdometro() != null) {
            String path = ImageUtil.saveImage(
                    cargaDiesel.getFotoOdometro(),
                    "Odometro",
                    String.valueOf(cargaDiesel.getUnidadID() + "_" + cargaDiesel.getFecha()),
                    BASE_DIRECTORY + "odometros\\");
            cargaDiesel.setFotoOdometro(path);
        }

        if (cargaDiesel.getFotoSello() != null) {
            String path = ImageUtil.saveImage(
                    cargaDiesel.getFotoSello(),
                    "Sello",
                    String.valueOf(cargaDiesel.getUnidadID() + "_" + cargaDiesel.getFecha()),
                    BASE_DIRECTORY + "sellos//");
            cargaDiesel.setFotoSello(path);
        }

        // Guarda carga principal y obtiene el objeto con el ID autogenerado
        CargaDiesel saveCargaDiesel = combustibleCargasDieselRepository.save(cargaDiesel);

        // Inserta los tickets asociados
        if (saveCargaDiesel.getTickets() != null && !saveCargaDiesel.getTickets().isEmpty()) {
            // Recibe la imagen en Base64
            for (String ticketBase64 : saveCargaDiesel.getTickets()) {
                Ticket ticket = new Ticket();

                String path = ImageUtil.saveImage(ticketBase64, "Ticket",
                        cargaDiesel.getUnidadID().toString() + "_" + cargaDiesel.getFechaString(),
                        BASE_DIRECTORY + "tickets\\");
                ticket.setFoto(path);

                ticket.setCargaID(cargaDiesel.getCargaId());
                ticketRepository.save(ticket);
            }
        }

        // Ahora actualizamos la entidad con los paths correctos
        combustibleCargasDieselRepository.save(saveCargaDiesel);

        return saveCargaDiesel;
    }

}
