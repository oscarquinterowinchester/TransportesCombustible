package com.appchoferes.nomina.services.lorasdb;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appchoferes.nomina.models.lorasdb.dtos.PuntosSemanaResponse;
import com.appchoferes.nomina.repositories.lorasdb.RegistroPuntoInspeccionRepo;

@Service
public class RegistroPuntoInspeccionServ {

    @Autowired
    private RegistroPuntoInspeccionRepo registroPuntoInspeccionRepository;

    public List<PuntosSemanaResponse> getPuntosSemana() {
        List<Object[]> resultados = registroPuntoInspeccionRepository.findPuntosSemana();

        return resultados.stream()
                .map(result -> {
                    int dia_semana = ((Number) result[0]).intValue(); // dia_semana
                    int hora = ((Number) result[1]).intValue(); // hora
                    String ids = (String) result[2]; // ids
                    String puntos = (String) result[3]; // puntos
                    String estados = (String) result[4]; // estados

                    // Asegúrate de que los datos no sean nulos
                    ids = ids != null ? ids : "";
                    puntos = puntos != null ? puntos : "";
                    estados = estados != null ? estados : "";

                    return new PuntosSemanaResponse(dia_semana, hora, ids, puntos, estados);
                })
                .collect(Collectors.toList());
    }
}
