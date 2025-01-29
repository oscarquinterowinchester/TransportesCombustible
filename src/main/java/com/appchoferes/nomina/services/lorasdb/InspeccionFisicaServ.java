package com.appchoferes.nomina.services.lorasdb;

import java.util.Date;
import java.util.List;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appchoferes.nomina.models.lorasdb.InspeccionFisica;
import com.appchoferes.nomina.models.lorasdb.RegistroPuntoInspeccion;
import com.appchoferes.nomina.models.lorasdb.dtos.ListaInspeccionRequest;
import com.appchoferes.nomina.repositories.lorasdb.InspeccionFisicaRepo;
import com.appchoferes.nomina.repositories.lorasdb.RegistroPuntoInspeccionRepo;

@Service
public class InspeccionFisicaServ {
    
    @Autowired
    private InspeccionFisicaRepo inspFisicaRepo;

    @Autowired
    private RegistroPuntoInspeccionRepo regPuntoInsRepo;

    public void saveListaInspeccion(ListaInspeccionRequest request){
        Integer guardia = request.getGuardia();
        String nota = request.getNota();

        // Obtener solo la parte de la fecha sin la hora
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        Date fechaActual = calendar.getTime();

        // Buscar inspecciones en la misma fecha y guardia
        List<InspeccionFisica> result = inspFisicaRepo.findByGuardiaAndFecha(guardia, fechaActual);
        Integer tipo;
        Integer idInspeccion;

        if (result.isEmpty()) {
            tipo = 1;
            InspeccionFisica nuevaInspeccionFisica = new InspeccionFisica();
            nuevaInspeccionFisica.setGuardia(guardia);
            nuevaInspeccionFisica.setNota(nota);
            nuevaInspeccionFisica.setFecha(new Date()); // Guarda con hora actual
            InspeccionFisica savedInspeccionFisica = inspFisicaRepo.save(nuevaInspeccionFisica);
            idInspeccion = savedInspeccionFisica.getId();
        } else {
            tipo = 2;
            idInspeccion = result.get(0).getId();
        }

        if(idInspeccion != null) {
            request.getListaPuntos().forEach(punto -> {
                RegistroPuntoInspeccion registro = new RegistroPuntoInspeccion();
                registro.setEstado(punto.getEstado());
                registro.setPunto(punto.getId());
                registro.setIdInspeccion(idInspeccion);
                registro.setTipoInspeccion(tipo);
                regPuntoInsRepo.save(registro);
            });
        }
    }
}
