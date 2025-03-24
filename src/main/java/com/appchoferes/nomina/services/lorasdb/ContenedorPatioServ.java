package com.appchoferes.nomina.services.lorasdb;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appchoferes.nomina.models.lorasdb.dtos.ContenedorPatiosDTO;
import com.appchoferes.nomina.models.lorasdb.dtos.ContenedorTipo1DTO;
import com.appchoferes.nomina.repositories.lorasdb.ContenedorRepo;
import com.appchoferes.nomina.repositories.lorasdb.InventarioExternoRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Service
public class ContenedorPatioServ {

    @Autowired
    private ContenedorRepo contenedorRepo;

    @Autowired
    private InventarioExternoRepository inventarioExternoRepository;

    @PersistenceContext
    private EntityManager entityManager;

    public Map<String, Object> obtenerContenedores(int patioId, int usuarioId) {
        // Consulta nativa para obtener los contenedores
        String sql = """
                    SELECT
                        w.InventarioID AS inventarioID,
                        w.ItinerarioID AS itinerarioID,
                        w.WContenedorID AS wContenedorID,
                        w.Contenedor AS contenedor,
                        w.PlacasChasis AS placasChasis,
                        w.Sello AS sello,
                        w.PaisID AS paisID,
                        w.ClienteID AS clienteID,
                        w.EstadoCarga AS estadoCarga,
                        w.TipoEvento AS tipoEvento,
                        w.FechaEvento AS fechaEvento,
                        IFNULL(w.Camion, '') AS camion,
                        (SELECT Origen FROM rutas_tbl WHERE rutas_tbl.RutaID = w.RutaID LIMIT 1) AS origen,
                        (SELECT Destino FROM rutas_tbl WHERE rutas_tbl.RutaID = w.RutaID LIMIT 1) AS destino,
                        IF(w.CamionID > 0, 'MX', '') AS carrier
                    FROM inventarioexterno_tbl AS w
                    WHERE w.PatioID = :patioId
                    AND w.TipoEvento = 1
                    AND w.UsuarioId = :usuarioId
                """;

        // Crear la consulta nativa
        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("patioId", patioId);
        query.setParameter("usuarioId", usuarioId);

        // Ejecutar la consulta y obtener los resultados
        List<Object[]> results = query.getResultList();

        // Mapear los resultados a ContenedorPatiosDTO con validaciones de nulos
        List<ContenedorPatiosDTO> contenedores = results.stream()
                .map(row -> new ContenedorPatiosDTO(
                        row[0] != null ? ((Number) row[0]).intValue() : 0, // inventarioID
                        row[1] != null ? ((Number) row[1]).intValue() : 0, // itinerarioID
                        row[2] != null ? ((Number) row[2]).intValue() : 0, // wContenedorID
                        row[3] != null ? (String) row[3] : "N/A", // contenedor
                        row[4] != null ? (String) row[4] : "No disponible", // placasChasis
                        row[5] != null ? (String) row[5] : "N/A", // sello
                        row[6] != null ? ((Number) row[6]).intValue() : 0, // paisID
                        row[7] != null ? ((Number) row[7]).intValue() : 0, // clienteID
                        row[8] != null ? ((Number) row[8]).intValue() : 0, // estadoCarga
                        row[9] != null ? ((Number) row[9]).intValue() : 0, // tipoEvento
                        row[10] != null ? ((java.sql.Timestamp) row[10]).toLocalDateTime() : null, // fechaEvento
                        row[11] != null ? (String) row[11] : "Desconocido", // camion
                        row[12] != null ? (String) row[12] : "Desconocido", // origen
                        row[13] != null ? (String) row[13] : "No asignado", // destino
                        row[14] != null ? (String) row[14] : "Sin Carrier" // carrier
                ))
                .collect(Collectors.toList());

        // Calcular los vacíos y cargados
        int vacios = 0;
        int cargados = 0;

        for (ContenedorPatiosDTO contenedor : contenedores) {
            if (contenedor.getEstadoCarga() == 0) {
                vacios++;
            } else {
                cargados++;
            }
        }

        // Estructura de la respuesta
        Map<String, Object> response = new HashMap<>();
        Map<String, Object> info = new HashMap<>();
        info.put("vacios", vacios);
        info.put("cargados", cargados);
        response.put("info", info);
        response.put("contenedores", contenedores);

        return response;
    }

    // ****** //
    public Object getContenedorEntrada(Long itinerarioId, String contenedor, Integer tipo) {
        if ((itinerarioId == null || itinerarioId < 0) && (contenedor == null || contenedor.isEmpty())) {
            return crearRespuestaDatosNoEncontrados();
        }

        List<Map<String, Object>> contenedoresSEND = new ArrayList<>();
        Map<String, Object> respuesta = new HashMap<>();

        // Buscar si el contenedor ya tiene una entrada registrada
        boolean tieneEntrada = false;

        if (tipo == 1) {
            if (contenedor != null && !contenedor.isEmpty()) {
                // Buscar InventarioID por contenedor
                List<Map<String, Object>> entradas = contenedorRepo
                        .findInventarioIdAndItinerarioIdByContenedor(contenedor);

                if (!entradas.isEmpty()) {
                    // Fusionar datos de entradas con contenedorInfo
                    List<Map<String, Object>> combinedDataList = new ArrayList<>();

                    for (Map<String, Object> entrada : entradas) {
                        Map<String, Object> combinedData = new HashMap<>();
                        combinedData.putAll(entrada); // Agregar datos de entradas

                        // Obtener ItinerarioID de la entrada actual
                        Long itiId = ((Number) entrada.get("ItinerarioID")).longValue();

                        // Buscar información adicional del contenedor usando ItinerarioID
                        List<Map<String, Object>> contenedorInfo = contenedorRepo.getInformacionEntrada(itiId);

                        if (!contenedorInfo.isEmpty()) {
                            combinedData.putAll(contenedorInfo.get(0)); // Fusionar datos de contenedorInfo
                        }

                        combinedDataList.add(combinedData); // Agregar a la lista de datos combinados
                    }

                    tieneEntrada = true;
                    respuesta.put("tieneEntrada", tieneEntrada);
                    respuesta.put("status", "success");
                    respuesta.put("message", "Contenedor encontrado");
                    respuesta.put("data", combinedDataList); // Agregar los datos fusionados
                    return respuesta;
                } else {
                    // Buscar ItinerarioID por contenedor
                    List<Map<String, Object>> itinerarios = contenedorRepo.findItinerarioIdByContenedor(contenedor);

                    if (!itinerarios.isEmpty()) {
                        for (Map<String, Object> itinerario : itinerarios) {
                            Long itiId = ((Number) itinerario.get("ItinerarioID")).longValue();
                            List<Map<String, Object>> contenedorInfo = contenedorRepo.getInformacionEntrada(itiId);

                            if (!contenedorInfo.isEmpty()) {
                                // Fusionar contenedorInfo con los datos existentes en data
                                Map<String, Object> combinedData = new HashMap<>();
                                combinedData.putAll(contenedorInfo.get(0));
                                combinedData.put("tieneEntrada", tieneEntrada);

                                respuesta.put("status", "success");
                                respuesta.put("message", "Contenedor encontrado");
                                respuesta.put("data", Collections.singletonList(combinedData)); // Agregar los datos
                                                                                                // fusionados en una
                                                                                                // lista
                                return respuesta;
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
            if (itinerarioId != null) {
                // Buscar InventarioID por ItinerarioID
                List<Map<String, Object>> entrada = contenedorRepo.findInventarioIdByItinerarioId(itinerarioId);
                List<Map<String, Object>> contenedorInfo = contenedorRepo.getInformacionEntrada(itinerarioId);

                if (!entrada.isEmpty() || !contenedorInfo.isEmpty()) {
                    // Fusionar contenedorInfo con los datos existentes en data
                    Map<String, Object> combinedData = new HashMap<>();

                    if (!entrada.isEmpty()) {
                        combinedData.putAll(entrada.get(0)); // Agregar datos de entrada
                    }

                    if (!contenedorInfo.isEmpty()) {
                        combinedData.putAll(contenedorInfo.get(0)); // Agregar datos de contenedorInfo
                    }

                    combinedData.put("tieneEntrada", tieneEntrada); // Agregar el campo tieneEntrada

                    respuesta.put("status", "success");
                    respuesta.put("message", "Itinerario encontrado");
                    respuesta.put("data", Collections.singletonList(combinedData)); // Agregar los datos fusionados en
                                                                                    // una lista
                    return respuesta;
                } else {
                    return crearRespuestaDatosNoEncontrados();
                }
            }
        }

        return crearRespuestaDatosNoEncontrados();
    }

    private Object crearRespuestaDatosNoEncontrados() {
        return Map.of("status", "error", "message", "Datos no encontrados");
    }

    public Map<String, Object> getContenedorPatio(String contenedor, Integer tipo, Integer itinerarioId) {
        List<ContenedorTipo1DTO> contenedoresSEND = new ArrayList<>();
        Map<String, Object> response = new HashMap<>();

        if ((esDatoInvalido(itinerarioId) && tipo == 2) || (esDatoInvalido(contenedor) && tipo == 1)) {
            response.put("contenedores", contenedoresSEND);
            response.put("tieneEntrada", false);
            return response; // Retorna lista vacía si los datos son inválidos
        }

        if (tipo == 1) {
            // Lógica para tipo 1
            String sql = "SELECT InventarioID FROM inventarioexterno_tbl WHERE contenedor = :contenedor AND TipoEvento = 1 ORDER BY InventarioID DESC Limit 1";
            Query query = entityManager.createNativeQuery(sql);
            query.setParameter("contenedor", contenedor);
            List<Integer> entradas = query.getResultList();

            if (!entradas.isEmpty()) {
                for (Integer entrada : entradas) {
                    String sqlSalida = "SELECT i.InventarioID FROM inventarioexterno_tbl i " +
                            "WHERE i.contenedor = :contenedor AND i.AnteriorID = :anteriorID AND i.TipoEvento = 2";
                    Query querySalida = entityManager.createNativeQuery(sqlSalida);
                    querySalida.setParameter("contenedor", contenedor);
                    querySalida.setParameter("anteriorID", entrada);
                    List<Long> salidas = querySalida.getResultList();

                    if (salidas.isEmpty()) {
                        String sqlItinerario = "SELECT getItinerarioRemolque(:contenedor) as ItinerarioID";
                        Query queryItinerario = entityManager.createNativeQuery(sqlItinerario);
                        queryItinerario.setParameter("contenedor", contenedor);
                        List<Integer> itinerarioIDs = queryItinerario.getResultList();

                        if (!itinerarioIDs.isEmpty()) {
                            for (Integer iti : itinerarioIDs) {
                                if (iti != null) {
                                    String sqlContenedorB = "call getDatosSalidaComplejo(:itinerarioID)";
                                    Query queryContenedorB = entityManager.createNativeQuery(sqlContenedorB);
                                    queryContenedorB.setParameter("itinerarioID", iti);
                                    List<Object[]> resultados = queryContenedorB.getResultList();
                                    for (Object[] resultado : resultados) {
                                        contenedoresSEND.add(mapToContenedorTipo1DTO(resultado));
                                    }
                                }
                            }
                        }
                    } else {
                        response.put("tieneEntrada", false); // No tiene entradas
                    }
                }
            } else {
                response.put("tieneEntrada", false); // No tiene entradas
            }
        } else if (tipo == 2) {
            // Lógica para tipo 2
            String sqlEntrada = "SELECT i.InventarioID FROM inventarioexterno_tbl i " +
                    "WHERE i.ItinerarioID = :itinerarioID AND i.TipoEvento = 1 " +
                    "AND getInventarioIdSalidaIti(i.ItinerarioID, i.InventarioID) IS NULL " +
                    "ORDER BY i.InventarioID DESC limit 1";
            Query queryEntrada = entityManager.createNativeQuery(sqlEntrada);
            queryEntrada.setParameter("itinerarioID", itinerarioId);
            List<Integer> entradas = queryEntrada.getResultList();

            if (!entradas.isEmpty()) {
                Integer entrada = entradas.get(0);
                String sqlSalida = "SELECT i.InventarioID FROM inventarioexterno_tbl i " +
                        "WHERE i.AnteriorID = :anteriorID AND i.TipoEvento = 2";
                Query querySalida = entityManager.createNativeQuery(sqlSalida);
                querySalida.setParameter("anteriorID", entrada);
                List<Integer> salidas = querySalida.getResultList();

                if (salidas.isEmpty()) {
                    String sqlContenedor = "call getDatosSalidaComplejo(:itinerarioID)";
                    Query queryContenedor = entityManager.createNativeQuery(sqlContenedor);
                    queryContenedor.setParameter("itinerarioID", itinerarioId);
                    List<Object[]> resultados = queryContenedor.getResultList();
                    for (Object[] resultado : resultados) {
                        contenedoresSEND.add(mapToContenedorTipo1DTO(resultado));
                    }
                    response.put("tieneEntrada", false); // No tiene entradas
                } else {
                    response.put("tieneEntrada", true); // Tiene entradas
                }
            } else {
                response.put("tieneEntrada", false); // No tiene entradas
            }
        }

        response.put("contenedores", contenedoresSEND);
        return response;
    }

    private ContenedorTipo1DTO mapToContenedorTipo1DTO(Object[] resultado) {
        ContenedorTipo1DTO dto = new ContenedorTipo1DTO();

        // Mapeo de los campos con validaciones de nulos
        dto.setInventarioID(resultado[0] != null ? ((Number) resultado[0]).intValue() : 0);
        dto.setItinerarioID(resultado[1] != null ? ((Number) resultado[1]).intValue() : 0);
        dto.setContenedor(resultado[2] != null ? (String) resultado[2] : "N/A");
        dto.setClienteFK(resultado[3] != null ? ((Number) resultado[3]).intValue() : 0);
        dto.setOrigen(resultado[4] != null ? (String) resultado[4] : "Desconocido");
        dto.setSello(resultado[5] != null ? (String) resultado[5] : "N/A");
        dto.setEstadoMex(resultado[6] != null ? (String) resultado[6] : "Desconocido");
        dto.setRutaID(resultado[7] != null ? ((Number) resultado[7]).intValue() : 0);
        dto.setCarrier(resultado[8] != null ? (String) resultado[8] : "Sin Carrier");
        dto.setTamano(resultado[9] != null ? (String) resultado[9] : "No especificado");
        dto.setPais(resultado[10] != null ? (String) resultado[10] : "No definido");
        dto.setCarga(resultado[11] != null ? (String) resultado[11] : "Desconocido");
        dto.setEstadoUSA(resultado[12] != null ? (String) resultado[12] : "Desconocido");
        dto.setRuta(resultado[13] != null ? (String) resultado[13] : "No asignada");
        dto.setCamion(resultado[14] != null ? (String) resultado[14] : "Desconocido");
        dto.setPlacasChasis(resultado[15] != null ? (String) resultado[15] : "No disponible");
        dto.setPlacasUnidad(resultado[16] != null ? (String) resultado[16] : "No disponible");
        dto.setNombreChofer(resultado[17] != null ? (String) resultado[17] : "Sin asignar");
        dto.setChoferID(resultado[18] != null ? ((Number) resultado[18]).intValue() : 0);
        dto.setClienteID(resultado[19] != null ? ((Number) resultado[19]).intValue() : 0);
        dto.setCliente(resultado[20] != null ? (String) resultado[20] : "Desconocido");

        return dto;
    }

    private boolean esDatoInvalido(Object dato) {
        return dato == null || (dato instanceof String && ((String) dato).isEmpty());
    }

}
