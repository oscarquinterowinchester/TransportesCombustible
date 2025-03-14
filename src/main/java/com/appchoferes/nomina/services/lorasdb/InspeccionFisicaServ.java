package com.appchoferes.nomina.services.lorasdb;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appchoferes.nomina.models.lorasdb.InspeccionFisica;
import com.appchoferes.nomina.models.lorasdb.RegistroPuntoInspeccion;
import com.appchoferes.nomina.models.lorasdb.dtos.PuntoInspeccionDTO;
import com.appchoferes.nomina.repositories.lorasdb.InspeccionFisicaRepo;
import com.appchoferes.nomina.repositories.lorasdb.RegistroPuntoInspeccionRepo;

@Service
public class InspeccionFisicaServ {

    @Autowired
    private InspeccionFisicaRepo inspFisicaRepo;

    @Autowired
    private RegistroPuntoInspeccionRepo regPuntoInsRepo;

    public String saveListaInspeccion(Map<String, PuntoInspeccionDTO> listaPuntos, int guardia, String nota) {
        Date fecha = new Date();
        InspeccionFisica inspeccion = inspFisicaRepo.findByGuardiaAndFecha(guardia, fecha);

        // Crear una nueva inspección si no existe
        if (inspeccion == null) {
            inspeccion = new InspeccionFisica();
            inspeccion.setGuardia(guardia);
            inspeccion.setFecha(fecha);
            inspeccion.setNota(nota);
            inspFisicaRepo.save(inspeccion);
        }

        // Recorrer el mapa de puntos
        for (Map.Entry<String, PuntoInspeccionDTO> entry : listaPuntos.entrySet()) {
            String clave = entry.getKey(); // Ejemplo: "ladoEste", "ladoOeste", etc.
            PuntoInspeccionDTO punto = entry.getValue(); // Objeto PuntoInspeccionDTO

            // Crear y guardar el registro de punto de inspección
            RegistroPuntoInspeccion registro = new RegistroPuntoInspeccion();
            registro.setPunto(punto.getId());
            registro.setEstado(String.valueOf(punto.getEstado()));
            registro.setFechaRegistro(fecha);
            registro.setIdInspeccion(inspeccion.getId());
            registro.setTipoInspeccion(inspeccion == null ? 1 : 2);
            regPuntoInsRepo.save(registro);
        }

        return "{\"message\":\"Inspección guardada exitosamente.\"}";
    }
}