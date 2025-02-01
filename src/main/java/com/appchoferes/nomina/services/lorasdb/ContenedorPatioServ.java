package com.appchoferes.nomina.services.lorasdb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appchoferes.nomina.models.lorasdb.dtos.ContenedorPatios;
import com.appchoferes.nomina.repositories.lorasdb.ContenedorPatioRepo;
import com.appchoferes.nomina.repositories.lorasdb.ContenedorRepo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ContenedorPatioServ {

    @Autowired
    private ContenedorPatioRepo repository;

    @Autowired
    private ContenedorRepo contenedorRepo;

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

        public Object getContenedorEntrada(Long itinerarioId, String contenedor, Integer tipo) {
        if ((itinerarioId == null || itinerarioId <= 0) && (contenedor == null || contenedor.isEmpty())) {
            return crearRespuestaDatosNoEncontrados();
        }

        List<Map<String, Object>> contenedoresSEND = new ArrayList<>();

        if (tipo == 1) {
            if (contenedor != null && !contenedor.isEmpty()) {
                // Buscar InventarioID por contenedor
                List<Map<String, Object>> entradas = contenedorRepo.findInventarioIdByContenedor(contenedor);

                if (!entradas.isEmpty()) {
                    return crearRespuestaContenedorEntrada();
                } else {
                    // Buscar ItinerarioID por contenedor
                    List<Map<String, Object>> itinerarios = contenedorRepo.findItinerarioIdByContenedor(contenedor);

                    if (!itinerarios.isEmpty()) {
                        for (Map<String, Object> itinerario : itinerarios) {
                            Long itiId = ((Number) itinerario.get("ItinerarioID")).longValue();
                            List<Map<String, Object>> contenedorInfo = contenedorRepo.getInformacionEntrada(itiId);

                            if (!contenedorInfo.isEmpty()) {
                                contenedoresSEND.add(contenedorInfo.get(0));
                                return contenedoresSEND;
                            }
                        }
                    } else {
                        return crearRespuestaDatosNoEncontrados();
                    }
                }
            }
            return contenedoresSEND.isEmpty() ? 15 : contenedoresSEND;
        }

        if (tipo == 2) {
            if (itinerarioId != null && itinerarioId > 0) {
                // Buscar InventarioID por ItinerarioID
                List<Map<String, Object>> entrada = contenedorRepo.findInventarioIdByItinerarioId(itinerarioId);

                if (!entrada.isEmpty()) {
                    return crearRespuestaItinerarioEntrada();
                } else {
                    // Obtener información de entrada por ItinerarioID
                    List<Map<String, Object>> contenedorInfo = contenedorRepo.getInformacionEntrada(itinerarioId);
                    return contenedorInfo;
                }
            }
        }

        return crearRespuestaDatosNoEncontrados();
    }

    private Object crearRespuestaDatosNoEncontrados() {
        return Map.of("status", "error", "message", "Datos no encontrados");
    }

    private Object crearRespuestaContenedorEntrada() {
        return Map.of("status", "success", "message", "Contenedor encontrado");
    }

    private Object crearRespuestaItinerarioEntrada() {
        return Map.of("status", "success", "message", "Itinerario encontrado");
    }
}
