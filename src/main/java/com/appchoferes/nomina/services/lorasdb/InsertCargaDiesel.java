package com.appchoferes.nomina.services.lorasdb;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appchoferes.nomina.models.lorasdb.CargaDiesel;
import com.appchoferes.nomina.repositories.lorasdb.CombustibleCargasDieselRepository;
import com.appchoferes.nomina.utils.DateUtil;
import com.appchoferes.nomina.utils.HoraUtil;
import com.appchoferes.nomina.utils.ImageUtil;

@Service
public class InsertCargaDiesel {

    @Autowired
    private CombustibleCargasDieselRepository combustibleCargasDieselRepository;

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

        if (cargaDiesel.getHoraString() != null) {
            LocalTime hora = HoraUtil.convertHora12a24(cargaDiesel.getHoraString());
            cargaDiesel.setHora(hora);
        }

        // pasar la Fecha de string a localDate para almacenar en la base de datos
        if (cargaDiesel.getFechaString() != null && !cargaDiesel.getFechaString().isEmpty()) {
            LocalDate fecha = DateUtil.convertStringToLocalDate(cargaDiesel.getFechaString());
            cargaDiesel.setFecha(fecha);
        }

        // validarCargaDiesel(cargaDiesel);
        return combustibleCargasDieselRepository.save(cargaDiesel);
    }

}
