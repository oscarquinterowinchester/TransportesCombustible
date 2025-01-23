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

    public static final String BASE_DIRECTORY = "/home/drago/work/lorasImagenes/";

    public CargaDiesel insertarCargaDiesel(CargaDiesel cargaDiesel) throws Exception {

        // Procesamos las imagenes antes de guardarlas
        if (cargaDiesel.getFotoTanque1() != null) {
            String path = ImageUtil.saveImage(cargaDiesel.getFotoTanque1(), "FotoTanque1",
                    BASE_DIRECTORY + "tanques/");
            cargaDiesel.setFotoTanque1(path);
        }

        if (cargaDiesel.getFotoTanque2() != null) {
            String path = ImageUtil.saveImage(cargaDiesel.getFotoTanque2(), "FotoTanque2",
                    BASE_DIRECTORY + "tanques/");
            cargaDiesel.setFotoTanque2(path);
        }

        if (cargaDiesel.getFirma() != null) {
            String path = ImageUtil.saveImage(cargaDiesel.getFirma(), "Firma", BASE_DIRECTORY + "firmas/");
            cargaDiesel.setFirma(path);
        }

        if (cargaDiesel.getFotoOdometro() != null) {
            String path = ImageUtil.saveImage(cargaDiesel.getFotoOdometro(), "Odometro", BASE_DIRECTORY + "odometros/");
            cargaDiesel.setFotoOdometro(path);
        }

        if (cargaDiesel.getFotoSello() != null) {
            String path = ImageUtil.saveImage(cargaDiesel.getFotoSello(), "Sello", BASE_DIRECTORY + "sellos/");
            cargaDiesel.setFotoSello(path);
        }

        // Guarda carga principal
        CargaDiesel saveCargaDiesel = combustibleCargasDieselRepository.save(cargaDiesel);

        // Inserta los tickets asociados 
        if(cargaDiesel.getTickets() != null && !cargaDiesel.getTickets().isEmpty()){
            for (Ticket ticket : cargaDiesel.getTickets()) {
                
                // Guardamos la imagen en el path especificado
                if(ticket.getFoto() != null){
                    String path = ImageUtil.saveImage(ticket.getFoto(), "Ticket", BASE_DIRECTORY + "tickets/");
                    ticket.setFoto(path);
                }

                ticket.setCargaID(cargaDiesel.getCargaId()); // Asocia el ticket con el id de la cargaDiesel 
                ticketRepository.save(ticket); // Guarda el ticket
            }
        }

        return saveCargaDiesel;
    }

}
