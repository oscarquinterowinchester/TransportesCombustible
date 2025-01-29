package com.appchoferes.nomina.services.lorasdb;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appchoferes.nomina.models.lorasdb.RegistroCorrespondencia;
import com.appchoferes.nomina.repositories.lorasdb.RegistroCorrespondenciaRepo;
import com.appchoferes.nomina.utils.ImageUtil;


@Service
public class RegistroCorrespondenciaServ {

    @Autowired
    private RegistroCorrespondenciaRepo rCrepo;

    public List<RegistroCorrespondencia> getRegistrosC(){
        List<RegistroCorrespondencia> registrosC = rCrepo.getRegistrosC();
        return registrosC;
    }

    public RegistroCorrespondencia saveRegistro(RegistroCorrespondencia registro) {
        return rCrepo.save(registro);
    }

    public String saveFirma(RegistroCorrespondencia registro) throws Exception {
        if (registro.getFirma() != null) {
            String firmaPath = ImageUtil.saveImage(registro.getFirma(), "firma-entregado", "/home/drago/work/lorasImagenes/firmas/");
            registro.setFirma(firmaPath);
        }

        // Actualizar el registro con la fecha de entrega y la firma
        registro.setFechaEntrega(registro.getFechaEntrega());
        rCrepo.save(registro);
        return "Firma y fecha de entrega actualizadas correctamente";
    }
}
