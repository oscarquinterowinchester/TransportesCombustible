package com.appchoferes.nomina.services.lorasdb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appchoferes.nomina.models.lorasdb.Itinerario;
import com.appchoferes.nomina.models.lorasdb.P_InventarioExterno;
import com.appchoferes.nomina.models.lorasdb.dtos.ContenedorPatios;
import com.appchoferes.nomina.models.lorasdb.dtos.ContenedorTipo1DTO;
import com.appchoferes.nomina.models.lorasdb.dtos.ContenedorTipo2DTO;
import com.appchoferes.nomina.repositories.lorasdb.ContenedorPatioRepo;
import com.appchoferes.nomina.repositories.lorasdb.ContenedorRepo;
import com.appchoferes.nomina.repositories.lorasdb.InventarioExternoRepository;
import com.appchoferes.nomina.repositories.lorasdb.ItinerarioRepo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ContenedorPatioServ {

    @Autowired
    private ContenedorPatioRepo repository;

    @Autowired
    private ContenedorRepo contenedorRepo;

    @Autowired
    private InventarioExternoRepository inventarioExternoRepository;

    @Autowired 
    private ItinerarioRepo itinerarioRepo;

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

    // Métodos para tipo 1
    public List<ContenedorTipo1DTO> getEntradasByContenedor(String contenedor) {
        List<P_InventarioExterno> entradas = inventarioExternoRepository.findByContenedorAndTipoEvento(contenedor, 1);
        return entradas.stream()
                .map(this::mapToContenedorTipo1DTO)
                .collect(Collectors.toList());
    }

    private ContenedorTipo1DTO mapToContenedorTipo1DTO(P_InventarioExterno entrada) {
        ContenedorTipo1DTO dto = new ContenedorTipo1DTO();
        dto.setInventarioID(entrada.getInventarioID());
        dto.setContenedor(entrada.getContenedor());
        // Mapear otros campos según sea necesario
        return dto;
    }

    public List<Itinerario> getItinerariosByContenedor(String contenedor) {
        return itinerarioRepo.findByContenedor(contenedor);
    }

    // Métodos para tipo 2
    public List<ContenedorTipo2DTO> getEntradaByItinerarioID(int itinerarioID) {
        List<P_InventarioExterno> entradas = inventarioExternoRepository.findEntradaByItinerarioID(itinerarioID);
        return entradas.stream()
                .map(this::mapToContenedorTipo2DTO)
                .collect(Collectors.toList());
    }

    private ContenedorTipo2DTO mapToContenedorTipo2DTO(P_InventarioExterno entrada) {
        ContenedorTipo2DTO dto = new ContenedorTipo2DTO();
        dto.setItinerarioID(entrada.getInventarioID());
        dto.setContenedor(entrada.getContenedor());
        dto.setInventarioID(entrada.getInventarioID()); // Campo adicional para el tipo 2
        // Mapear otros campos según sea necesario
        return dto;
    }

    public List<P_InventarioExterno> getSalidaByAnteriorID(int anteriorID) {
        return inventarioExternoRepository.findSalidaByAnteriorID(anteriorID);
    }

    public List<Object[]> getContenedorByItinerarioID(int itinerarioID, int inventarioID) {
        return itinerarioRepo.findContenedorByItinerarioID(itinerarioID, inventarioID);
    }
}
