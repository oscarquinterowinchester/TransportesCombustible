package com.appchoferes.nomina.services.lorasdb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

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

    @PersistenceContext
    private EntityManager entityManager;

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
        // dto.setItinerarioId(entrada.getItinerarioId());
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

    @Transactional
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

    public List<ContenedorTipo1DTO> getContenedorPatio(String contenedor, Integer tipo, Integer itinerarioId) {
        List<ContenedorTipo1DTO> contenedoresSEND = new ArrayList<>();

        if ((esDatoInvalido(itinerarioId) && tipo == 2) || (esDatoInvalido(contenedor) && tipo == 1)) {
            return contenedoresSEND; // Retorna lista vacía si los datos son inválidos
        }

        if (tipo == 1) {
            String queryEntradas = "SELECT InventarioID FROM inventarioexterno_tbl WHERE contenedor = :contenedor AND TipoEvento = 1 ORDER BY InventarioID DESC LIMIT 1";
            Query entradasQuery = entityManager.createNativeQuery(queryEntradas);
            entradasQuery.setParameter("contenedor", contenedor);
            List<Integer> entradas = entradasQuery.getResultList();

            if (!entradas.isEmpty()) {
                for (Integer entrada : entradas) {
                    String querySalida = "SELECT InventarioID FROM inventarioexterno_tbl WHERE contenedor = :contenedor AND AnteriorID = :entrada AND TipoEvento = 2";
                    Query salidaQuery = entityManager.createNativeQuery(querySalida);
                    salidaQuery.setParameter("contenedor", contenedor);
                    salidaQuery.setParameter("entrada", entrada);
                    List<Integer> salidas = salidaQuery.getResultList();

                    if (!salidas.isEmpty()) {
                        String queryItinerarioIDs = "SELECT ItinerarioID FROM itinerarios_tbl WHERE ItinerarioID IN (SELECT ico.ItinerarioID FROM icont_tbl AS ico WHERE ico.Status = true AND (ncontenedor = :contenedor OR Caja = :contenedor)) AND Status = 1";
                        Query itinerarioIDsQuery = entityManager.createNativeQuery(queryItinerarioIDs);
                        itinerarioIDsQuery.setParameter("contenedor", contenedor);
                        List<Integer> itinerarioIDs = itinerarioIDsQuery.getResultList();

                        if (!itinerarioIDs.isEmpty()) {
                            for (Integer itinerarioID : itinerarioIDs) {
                                String queryContenedorB = """
                                        SELECT *, w.NumeroSello as Sello,
                                        w.CajaID as CajaID,
                                        IF(i.CamionID > 0, 'MX', '') as Carrier,
                                        PlacasChasis as NumeroChasis,
                                        ItinerarioID,
                                        (
                                            CASE
                                            WHEN PaisID = 1 THEN 'México'
                                            WHEN PaisID = 2 THEN 'USA'
                                            ELSE 'N/A'
                                            END
                                        ) as pais,
                                        '' as EmpresaChofer,
                                        IF(EstadoCarga = 0, 'Vacio', 'Cargado') as carga,
                                        (SElECT Nombre FROM estados_tbl WHERE EstadoID = (SELECT Placas FROM camiones_tbl WHERE camiones_tbl.CamionID = i.CamionID)) as estadomex,
                                        (SElECT Nombre FROM estados_tbl WHERE EstadoID = (SELECT PlacasUSA FROM camiones_tbl WHERE camiones_tbl.CamionID = i.CamionID)) as estadousa,
                                        (SELECT Nombre FROM rutas_tbl WHERE rutas_tbl.RutaID = i.RutaID) as ruta,
                                        (SELECT NoEconomico FROM camiones_tbl WHERE camiones_tbl.CamionID = i.CamionID) as camion,
                                        (SELECT concat(placas,' ',placasusa) FROM cajas_tbl WHERE cajas_tbl.CajaID = w.CajaID) as PlacasChasis,
                                        (SELECT concat(placas,' ',placasusa) FROM camiones_tbl WHERE camiones_tbl.CamionID = i.CamionID) as PlacasUnidad,
                                        (SELECT Origen from rutas_tbl where rutas_tbl.RutaID = i.RutaID) as origen,
                                        (SELECT Nombre FROM choferes_tbl WHERE ChoferID = i.ChoferID) as NombreChofer,
                                        (SELECT ChoferID FROM itinerarios_tbl WHERE ItinerarioID = i.ChoferID) as ChoferID,
                                        (SELECT clienteID FROM workorder_tbl WHERE workID=WorkOrderID) as ClienteID,
                                        (SELECT NComercial FROM clientes_tbl WHERE clienteID = (SELECT clienteID FROM workorder_tbl WHERE workID=WorkOrderID)) as cliente
                                        FROM workcontenedores_tbl as w
                                        LEFT JOIN itinerarios_tbl AS i ON i.WContFK = w.WContenedorID
                                        WHERE i.ItinerarioID = :itinerarioID
                                        AND w.Status = true
                                        AND i.Status = true
                                        """;
                                Query contenedorBQuery = entityManager.createNativeQuery(queryContenedorB);
                                contenedorBQuery.setParameter("itinerarioID", itinerarioID);

                                List<ContenedorTipo1DTO> contenedorBList = contenedorBQuery.getResultList();
                                contenedoresSEND.addAll(contenedorBList);
                            }
                        }
                    } else {
                        String queryContenedorB = """
                                select inv.ItinerarioID,inv.Contenedor,inv.ClienteID as ClienteFK,
                                    inv.origen,Sello,EstadoPlacasMex as estadomex, inv.RutaID,Carrier,
                                    Tamano,(CASE WHEN inv.PaisID = 1 THEN 'México'
                                    WHEN inv.PaisID = 2 THEN 'USA'
                                    ELSE 'N/A'
                                    END) AS pais,IF(EstadoCarga = 0, 'Vacio', 'Cargado') AS carga,
                                    (inv.EstadoPlacasUsa) AS estadousa, ru.Nombre as ruta, camion,
                                    PlacasChasisUSA as PlacasChasis, placasunidad as PlacasUnidad,NombreChofer,
                                    ChoferID,inv.ClienteID,EmpresaChofer as cliente,InventarioID
                                    from inventarioexterno_tbl inv
                                    left join camiones_tbl cam ON cam.camionID = inv.camionID
                                    left join rutas_tbl ru ON ru.rutaID = inv.rutaID
                                    where inventarioID = :entrada
                                """;
                        Query contenedorBQuery = entityManager.createNativeQuery(queryContenedorB);
                        contenedorBQuery.setParameter("entrada", entrada);
                        List<Object[]> contenedorBList = contenedorBQuery.getResultList();
                        for (Object[] row : contenedorBList) {
                            ContenedorTipo1DTO contenedorPatiosDTO = new ContenedorTipo1DTO(
                                    row[0] != null ? (Integer) row[0] : 0, // ItinerarioID
                                    row[1] != null ? (String) row[1] : "", // Contenedor
                                    row[2] != null ? (Integer) row[2] : 0, // ClienteFK
                                    row[3] != null ? (String) row[3] : "", // Origen
                                    row[4] != null ? (String) row[4] : "", // Sello
                                    row[5] != null ? (String) row[5] : "", // EstadoMex
                                    row[6] != null ? (Integer) row[6] : 0, // RutaID
                                    row[7] != null ? (String) row[7] : "", // Carrier
                                    row[8] != null ? (String) row[8] : "", // Tamano
                                    row[9] != null ? (String) row[9] : "", // Pais
                                    row[10] != null ? (String) row[10] : "", // Carga
                                    row[11] != null ? (String) row[11] : "", // EstadoUSA
                                    row[12] != null ? (String) row[12] : "", // Ruta
                                    row[13] != null ? (String) row[13] : "", // Camion
                                    row[14] != null ? (String) row[14] : "", // PlacasChasis
                                    row[15] != null ? (String) row[15] : "", // PlacasUnidad
                                    row[16] != null ? (String) row[16] : "", // NombreChofer
                                    row[17] != null ? (Integer) row[17] : 0, // ChoferID
                                    row[18] != null ? (Integer) row[18] : 0, // ClienteID
                                    row[19] != null ? (String) row[19] : "", // Cliente
                                    row[20] != null ? (Integer) row[20] : 0 // InventarioID
                            );
                            contenedoresSEND.add(contenedorPatiosDTO);
                        }
                    }
                }
            } else {
                // Lógica para cuando no hay entradas
                String queryItinerarioID = "SELECT ItinerarioID FROM itinerarios_tbl WHERE ItinerarioID IN (SELECT ico.ItinerarioID FROM icont_tbl AS ico WHERE ico.Status = true AND (ncontenedor = :contenedor OR Caja = :contenedor)) AND Status = 1";
                Query itinerarioIDQuery = entityManager.createNativeQuery(queryItinerarioID);
                itinerarioIDQuery.setParameter("contenedor", contenedor);
                List<Integer> itinerarioIDs = itinerarioIDQuery.getResultList();

                if (!itinerarioIDs.isEmpty()) {
                    for (Integer itinerarioID : itinerarioIDs) {
                        String queryContenedorB = """
                                select inv.ItinerarioID,inv.Contenedor,inv.ClienteID as ClienteFK,
                                    inv.origen,Sello,EstadoPlacasMex as estadomex, inv.RutaID,Carrier,
                                    Tamano,(CASE WHEN inv.PaisID = 1 THEN 'México'
                                    WHEN inv.PaisID = 2 THEN 'USA'
                                    ELSE 'N/A'
                                    END) AS pais,IF(EstadoCarga = 0, 'Vacio', 'Cargado') AS carga,
                                    (inv.EstadoPlacasUsa) AS estadousa, ru.Nombre as ruta, camion,
                                    PlacasChasisUSA as PlacasChasis, placasunidad as PlacasUnidad,NombreChofer,
                                    ChoferID,inv.ClienteID,EmpresaChofer as cliente,InventarioID
                                    from inventarioexterno_tbl inv
                                    left join camiones_tbl cam ON cam.camionID = inv.camionID
                                    left join rutas_tbl ru ON ru.rutaID = inv.rutaID
                                    where inventarioID = :itinerarioID
                                """;
                        Query contenedorBQuery = entityManager.createQuery(queryContenedorB);
                        contenedorBQuery.setParameter("itinerarioID", itinerarioID);
                        List<Object[]> contenedorBList = contenedorBQuery.getResultList();
                        for (Object[] row : contenedorBList) {
                            ContenedorTipo1DTO contenedorPatiosDTO = new ContenedorTipo1DTO(
                                    row[0] != null ? (Integer) row[0] : 0, // ItinerarioID
                                    row[1] != null ? (String) row[1] : "", // Contenedor
                                    row[2] != null ? (Integer) row[2] : 0, // ClienteFK
                                    row[3] != null ? (String) row[3] : "", // Origen
                                    row[4] != null ? (String) row[4] : "", // Sello
                                    row[5] != null ? (String) row[5] : "", // EstadoMex
                                    row[6] != null ? (Integer) row[6] : 0, // RutaID
                                    row[7] != null ? (String) row[7] : "", // Carrier
                                    row[8] != null ? (String) row[8] : "", // Tamano
                                    row[9] != null ? (String) row[9] : "", // Pais
                                    row[10] != null ? (String) row[10] : "", // Carga
                                    row[11] != null ? (String) row[11] : "", // EstadoUSA
                                    row[12] != null ? (String) row[12] : "", // Ruta
                                    row[13] != null ? (String) row[13] : "", // Camion
                                    row[14] != null ? (String) row[14] : "", // PlacasChasis
                                    row[15] != null ? (String) row[15] : "", // PlacasUnidad
                                    row[16] != null ? (String) row[16] : "", // NombreChofer
                                    row[17] != null ? (Integer) row[17] : 0, // ChoferID
                                    row[18] != null ? (Integer) row[18] : 0, // ClienteID
                                    row[19] != null ? (String) row[19] : "", // Cliente
                                    row[20] != null ? (Integer) row[20] : 0 // InventarioID
                            );
                            contenedoresSEND.add(contenedorPatiosDTO);
                        }

                    }
                } else {
                    return contenedoresSEND; // Retorna lista vacía si no se encuentran datos
                }
            }
        }

        if (tipo == 2) {
            String queryEntradas = """
                    SELECT InventarioID FROM inventarioexterno_tbl WHERE ItinerarioID = :itinerarioId AND TipoEvento = 1
                    AND getInventarioIdSalidaIti(ItinerarioID, InventarioID) IS NULL ORDER BY InventarioID DESC LIMIT 1
                    """;
            Query entradasQuery = entityManager.createNativeQuery(queryEntradas);
            entradasQuery.setParameter("contenedor", contenedor);
            List<Integer> entradas = entradasQuery.getResultList();

            if (!entradas.isEmpty()) {
                for (Integer entrada : entradas) {
                    String querySalida = """
                            SELECT InventarioID FROM inventarioexterno_tbl WHERE AnteriorID = :entrada AND TipoEvento = 2
                            """;
                    Query salidaQuery = entityManager.createNativeQuery(querySalida);
                    salidaQuery.setParameter("entrada", entrada);
                    List<Integer> salidas = salidaQuery.getResultList();

                    if (!salidas.isEmpty()) {
                        String queryContenedor = """
                                select iti.ItinerarioID,IF(ico.ncontenedor is null or ico.ncontenedor = '',ico.Caja,ico.ncontenedor) as Contenedor,
                                wo.ClienteFK,ru.origen,getSelloIti(iti.itinerarioId) as Sello, (SELECT Nombre FROM estados_tbl
                                WHERE EstadoID = (SELECT  Placas FROM camiones_tbl WHERE camiones_tbl.CamionID = iti.CamionID)) AS estadomex,
                                iti.RutaID,(select RazonSocial from empresas_tbl where EmpresaID = 1) as Carrier, wo.Tamano,
                                (CASE WHEN PaisID = 1 THEN 'México' WHEN PaisID = 2 THEN 'USA' ELSE 'N/A' END)
                                AS pais, IF(EstadoCarga = 0, 'Vacio', 'Cargado') AS carga,(SELECT Nombre FROM estados_tbl
                                WHERE EstadoID = (SELECT PlacasUSA FROM camiones_tbl WHERE camiones_tbl.CamionID = iti.CamionID)) 
                                AS estadousa, (SELECT Nombre FROM rutas_tbl WHERE rutas_tbl.RutaID = iti.RutaID) AS ruta,
                                (SELECT NoEconomico FROM camiones_tbl WHERE camiones_tbl.CamionID = iti.CamionID) AS camion,
                                (SELECT CONCAT(placas, ' ', placasusa) FROM cajas_tbl WHERE cajas_tbl.CajaID = wo.CajaID) 
                                AS PlacasChasis, (SELECT CONCAT(placas, ' ', placasusa) FROM camiones_tbl WHERE 
                                camiones_tbl.CamionID = iti.CamionID) AS PlacasUnidad, (SELECT Nombre FROM
                                choferes_tbl WHERE ChoferID = iti.choferID) AS NombreChofer, (iti.choferID) AS ChoferID,
                                (wo.ClienteFK) AS ClienteID, (SELECT NComercial FROM clientes_tbl WHERE  clienteID = wo.clienteFK) 
                                AS cliente, :entrada as InventarioID from itinerarios_tbl iti LEFT join icont_tbl ico 
                                ON ico.ItinerarioID = iti.ItinerarioID LEFT join workcontenedores_tbl wo ON wo.WContenedorID = ico.WContID
                                LEFT join rutas_tbl ru ON ru.RutaID = iti.RutaID here iti.itinerarioId = :itinerarioId
                                    """;
                        Query contenedorQuery = entityManager.createNativeQuery(queryContenedor);
                        contenedorQuery.setParameter("itinerarioId", itinerarioId);
                        contenedorQuery.setParameter("entrada", entrada);
                        List<Object[]> contenedorList = contenedorQuery.getResultList();
                        for (Object[] row : contenedorList) {
                            ContenedorTipo1DTO contenedorPatiosDTO = new ContenedorTipo1DTO(
                                    row[0] != null ? (Integer) row[0] : 0, // ItinerarioID
                                    row[1] != null ? (String) row[1] : "", // Contenedor
                                    row[2] != null ? (Integer) row[2] : 0, // ClienteFK
                                    row[3] != null ? (String) row[3] : "", // Origen
                                    row[4] != null ? (String) row[4] : "", // Sello
                                    row[5] != null ? (String) row[5] : "", // EstadoMex
                                    row[6] != null ? (Integer) row[6] : 0, // RutaID
                                    row[7] != null ? (String) row[7] : "", // Carrier
                                    row[8] != null ? (String) row[8] : "", // Tamano
                                    row[9] != null ? (String) row[9] : "", // Pais
                                    row[10] != null ? (String) row[10] : "", // Carga
                                    row[11] != null ? (String) row[11] : "", // EstadoUSA
                                    row[12] != null ? (String) row[12] : "", // Ruta
                                    row[13] != null ? (String) row[13] : "", // Camion
                                    row[14] != null ? (String) row[14] : "", // PlacasChasis
                                    row[15] != null ? (String) row[15] : "", // PlacasUnidad
                                    row[16] != null ? (String) row[16] : "", // NombreChofer
                                    row[17] != null ? (Integer) row[17] : 0, // ChoferID
                                    row[18] != null ? (Integer) row[18] : 0, // ClienteID
                                    row[19] != null ? (String) row[19] : "", // Cliente
                                    row[20] != null ? (Integer) row[20] : 0 // InventarioID
                            );
                            contenedoresSEND.add(contenedorPatiosDTO);
                        }
                    }
                }

            }

        }

        return contenedoresSEND;
    }

    private boolean esDatoInvalido(Object dato) {
        return dato == null || (dato instanceof String && ((String) dato).isEmpty());
    }

}
