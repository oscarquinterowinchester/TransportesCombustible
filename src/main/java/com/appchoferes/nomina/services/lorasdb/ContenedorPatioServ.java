package com.appchoferes.nomina.services.lorasdb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appchoferes.nomina.models.lorasdb.dtos.ContenedorPatios;
import com.appchoferes.nomina.repositories.lorasdb.ContenedorPatioRepo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ContenedorPatioServ {

    @Autowired
    private ContenedorPatioRepo repository;

    public Map<String, Object> obtenerContenedores(int patioId, int usuarioId) {
        List<ContenedorPatios> contenedores = repository.obtenerContenedores(patioId, usuarioId);

        int vacios = 0;
        int cargados = 0;

        for (ContenedorPatios contenedor : contenedores) {
            if (contenedor.getEstadoCarga() == 0) {
                vacios++;
            } else {
                cargados++;
            }
        }

        Map<String, Object> response = new HashMap<>();
        response.put("info", Map.of("vacios", vacios, "cargados", cargados));
        response.put("contenedores", contenedores);

        return response;
    }


}
