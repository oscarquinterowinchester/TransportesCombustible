package com.appchoferes.nomina.services.lorasdb;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.appchoferes.nomina.models.lorasdb.Itinerario;
import com.appchoferes.nomina.models.lorasdb.P_InventarioExterno;
import com.appchoferes.nomina.models.lorasdb.dtos.ContenedorPatios;
import com.appchoferes.nomina.models.lorasdb.dtos.ContenedorTipo1DTO;
import com.appchoferes.nomina.models.lorasdb.dtos.ContenedorTipo2DTO;
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
    private ContenedorRepo contenedorRepo;

    @Autowired
    private InventarioExternoRepository inventarioExternoRepository;

    @Autowired
    private ItinerarioRepo itinerarioRepo;

    private final JdbcTemplate jdbcTemplate;

    public ContenedorPatioServ(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @PersistenceContext
    private EntityManager entityManager;

    public Map<String, Object> obtenerContenedores(int patioId, int usuarioId) {
        String sql = """
                    SELECT *,
                        IF(PaisID = 1, 'México', 'Estados unidos') AS pais,
                        IF(EstadoCarga = 0, 'Vacio', 'Cargado') AS carga,
                        (SELECT NComercial FROM clientes_tbl WHERE clienteID = w.ClienteID LIMIT 1) AS cliente,
                        (SELECT Origen FROM rutas_tbl WHERE rutas_tbl.RutaID = w.RutaID LIMIT 1) AS origen,
                        (SELECT Nombre FROM estados_tbl WHERE EstadoID = w.EstadoID LIMIT 1) AS estado,
                        DATEDIFF(NOW(), FechaEvento) AS dias,
                        (SELECT InventarioID FROM inventarioexterno_tbl WHERE AnteriorID = w.InventarioID AND TipoEvento = 2 LIMIT 1) AS flag,
                        IFNULL(sello, '') AS sello,
                        IFNULL(FechaEvento, NULL) AS FechaEvento,
                        IFNULL(Fecha, NULL) AS Fecha,
                        IFNULL(FechaElimina, NULL) AS FechaElimina,
                        IFNULL(FechaEdicion, NULL) AS FechaEdicion
                    FROM inventarioexterno_tbl AS w
                    WHERE PatioID = ?
                    AND TipoEvento = 1
                    AND UsuarioId = ?
                """;

        List<ContenedorPatios> contenedores = jdbcTemplate.query(sql, new Object[] { patioId, usuarioId },
                new RowMapper<ContenedorPatios>() {
                    @Override
                    public ContenedorPatios mapRow(ResultSet rs, int rowNum) throws SQLException {
                        ContenedorPatios contenedor = new ContenedorPatios();
                        contenedor.setInventarioID(rs.getInt("InventarioID"));
                        contenedor.setItinerarioID(rs.getInt("ItinerarioID"));
                        contenedor.setAnteriorID(rs.getInt("AnteriorID"));
                        contenedor.setWContenedorID(rs.getString("WContenedorID"));
                        contenedor.setContenedor(rs.getString("Contenedor"));
                        contenedor.setPlacasChasis(rs.getString("PlacasChasis"));
                        contenedor.setSello(rs.getString("Sello"));
                        contenedor.setSelloDiesel(rs.getString("SelloDiesel"));
                        contenedor.setPaisID(rs.getInt("PaisID"));
                        contenedor.setEstadoID(rs.getInt("EstadoID"));
                        contenedor.setChoferID(rs.getInt("ChoferID"));
                        contenedor.setClienteID(rs.getInt("ClienteID"));
                        contenedor.setUsuarioID(rs.getInt("UsuarioID"));
                        contenedor.setRutaID(rs.getInt("RutaID"));
                        contenedor.setNombreChofer(rs.getString("NombreChofer"));
                        contenedor.setEmpresaChofer(rs.getString("EmpresaChofer"));
                        contenedor.setUsuarioEventoID(rs.getInt("UsuarioEventoID"));
                        contenedor.setNota(rs.getString("Nota"));
                        contenedor.setEstadoCarga(rs.getInt("EstadoCarga"));
                        contenedor.setTipoEvento(rs.getInt("TipoEvento"));
                        contenedor.setFechaEvento(safeStringToDate(rs.getString("FechaEvento")));
                        contenedor.setFecha(safeStringToDate(rs.getString("Fecha")));
                        contenedor.setPatioID(rs.getInt("PatioID"));
                        contenedor.setTamano(rs.getInt("Tamano"));
                        contenedor.setStatus(rs.getInt("Status"));
                        contenedor.setUsuarioEliminaID(rs.getInt("UsuarioEliminaID"));
                        contenedor.setFechaElimina(safeStringToDate(rs.getString("FechaElimina")));
                        contenedor.setCamion(rs.getString("Camion"));
                        contenedor.setEquipmentProvider(rs.getString("EquipmentProvider"));
                        contenedor.setEquipmentProviderExt(rs.getString("EquipmentProviderExt"));
                        contenedor.setFirmak9(rs.getString("Firmak9"));
                        contenedor.setBotando(rs.getInt("Botando"));
                        contenedor.setOrigen(rs.getString("Origen"));
                        contenedor.setCamionID(rs.getInt("CamionID"));
                        contenedor.setDestino(rs.getString("Destino"));
                        contenedor.setPlacasUnidad(rs.getString("PlacasUnidad"));
                        contenedor.setNumeroChasis(rs.getString("NumeroChasis"));
                        contenedor.setCarrier(rs.getString("Carrier"));
                        contenedor.setGrade(rs.getString("Grade"));
                        contenedor.setAssignedTo(rs.getString("AssignedTo"));
                        contenedor.setFechaEdicion(safeStringToDate(rs.getString("FechaEdicion")));
                        contenedor.setIsCamion(rs.getInt("IsCamion"));
                        contenedor.setPerfilCobroID(rs.getInt("PerfilCobroID"));
                        contenedor.setIsVirtual(rs.getInt("IsVirtual"));
                        contenedor.setPlacasChasisUSA(rs.getString("PlacasChasisUSA"));
                        contenedor.setEstadoUSAID(rs.getInt("EstadoUSAID"));
                        contenedor.setPlacasUnidadUSA(rs.getString("PlacasUnidadUSA"));
                        contenedor.setEstadoPlacasMex(rs.getString("EstadoPlacasMex"));
                        contenedor.setEstadoPlacasUsa(rs.getString("EstadoPlacasUsa"));
                        contenedor.setRemolqueEstado(rs.getString("RemolqueEstado"));
                        contenedor.setRemolquePais(rs.getString("RemolquePais"));
                        contenedor.setSoloChasis(rs.getInt("SoloChasis"));
                        contenedor.setCreacionUsuarioEventoID(rs.getInt("CreacionUsuarioEventoID"));
                        contenedor.setLicencia(rs.getString("Licencia"));
                        contenedor.setCajaID(rs.getInt("CajaID"));
                        contenedor.setChasis(rs.getString("Chasis"));
                        contenedor.setIsFull(rs.getInt("IsFull"));
                        contenedor.setFullItinerarioBase(rs.getInt("FullItinerarioBase"));
                        contenedor.setSelloComplementario(rs.getString("SelloComplementario"));
                        contenedor.setFotoSello(rs.getString("FotoSello"));
                        contenedor.setFirmaGuardia(rs.getString("FirmaGuardia"));
                        contenedor.setFirmaChofer(rs.getString("FirmaChofer"));
                        contenedor.setFacturado(rs.getInt("Facturado"));
                        contenedor.setTotalRenta(rs.getString("TotalRenta"));
                        contenedor.setEstado(rs.getString("Estado"));
                        contenedor.setPais(rs.getString("Pais"));
                        contenedor.setCarga(rs.getString("Carga"));
                        contenedor.setCliente(rs.getString("Cliente"));
                        // contenedor.setOrigenData(rs.getString("OrigenData"));
                        // contenedor.setEstadoData(rs.getString("EstadoData"));
                        contenedor.setDias(rs.getInt("Dias"));
                        contenedor.setFlag(rs.getInt("Flag"));
                        contenedor.setSello(rs.getString("Sello"));

                        return contenedor;
                    }
                });

        // Calcular los vacíos y cargados
        int vacios = 0;
        int cargados = 0;

        for (ContenedorPatios contenedor : contenedores) {
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

    // *** Funciones para manejar el mapeo de los dtos *** //
    private LocalDateTime safeStringToDate(String dateStr) {
        if (dateStr == null || dateStr.isEmpty()) {
            return null;
        }

        try {
            return LocalDateTime.parse(dateStr.replace(" ", "T"));
        } catch (Exception e) {
            return null; // Return null if the date is invalid
        }
    }
    // ****** //

    public Object getContenedorEntrada(Long itinerarioId, String contenedor, Integer tipo) {
        if ((itinerarioId == null || itinerarioId <= 0) && (contenedor == null || contenedor.isEmpty())) {
            return crearRespuestaDatosNoEncontrados();
        }

        List<Map<String, Object>> contenedoresSEND = new ArrayList<>();
        Map<String, Object> respuesta = new HashMap<>();

        if (tipo == 1) {
            if (contenedor != null && !contenedor.isEmpty()) {
                // Buscar InventarioID por contenedor
                List<Map<String, Object>> entradas = contenedorRepo.findInventarioIdByContenedor(contenedor);

                if (!entradas.isEmpty()) {
                    respuesta.put("status", "success");
                    respuesta.put("message", "Contenedor encontrado");
                    respuesta.put("data", entradas); // Agregar los datos recuperados
                    return respuesta;
                } else {
                    // Buscar ItinerarioID por contenedor
                    List<Map<String, Object>> itinerarios = contenedorRepo.findItinerarioIdByContenedor(contenedor);

                    if (!itinerarios.isEmpty()) {
                        for (Map<String, Object> itinerario : itinerarios) {
                            Long itiId = ((Number) itinerario.get("ItinerarioID")).longValue();
                            List<Map<String, Object>> contenedorInfo = contenedorRepo.getInformacionEntrada(itiId);

                            if (!contenedorInfo.isEmpty()) {
                                contenedoresSEND.add(contenedorInfo.get(0));
                                respuesta.put("status", "success");
                                respuesta.put("message", "Contenedor encontrado");
                                respuesta.put("data", contenedoresSEND); // Agregar los datos recuperados
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
            if (itinerarioId != null && itinerarioId > 0) {
                // Buscar InventarioID por ItinerarioID
                List<Map<String, Object>> entrada = contenedorRepo.findInventarioIdByItinerarioId(itinerarioId);

                if (!entrada.isEmpty()) {
                    respuesta.put("status", "success");
                    respuesta.put("message", "Itinerario encontrado");
                    respuesta.put("data", entrada); // Agregar los datos recuperados
                    return respuesta;
                } else {
                    // Obtener información de entrada por ItinerarioID
                    List<Map<String, Object>> contenedorInfo = contenedorRepo.getInformacionEntrada(itinerarioId);
                    respuesta.put("status", "success");
                    respuesta.put("message", "Itinerario encontrado");
                    respuesta.put("data", contenedorInfo); // Agregar los datos recuperados
                    return respuesta;
                }
            }
        }

        return crearRespuestaDatosNoEncontrados();
    }

    private Object crearRespuestaDatosNoEncontrados() {
        return Map.of("status", "error", "message", "Datos no encontrados");
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
        dto.setInventarioID(entrada.getInventarioID().longValue());
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

    /*
     * Obtine los contenedores del apartado de Patios Salida del modulo de
     * combustible
     * El tipo 1 busca en base al contenedor ingersado y el tipo 2 busca en en base
     * al itinearioId
     */
    public List<ContenedorTipo1DTO> getContenedorPatio(String contenedor, Integer tipo, Integer itinerarioId) {
        List<ContenedorTipo1DTO> contenedoresSEND = new ArrayList<>();

        if ((esDatoInvalido(itinerarioId) && tipo == 2) || (esDatoInvalido(contenedor) && tipo == 1)) {
            return contenedoresSEND; // Retorna lista vacia si los datos son invalidos
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
                                    row[20] != null ? ((Number) row[20]).longValue() : 0L// InventarioID
                            );
                            contenedoresSEND.add(contenedorPatiosDTO);
                        }
                    }
                }
            } else {
                // Logica para cuando no hay entradas
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
                                    row[20] != null ? ((Number) row[20]).longValue() : 0L// InventarioID
                            );
                            contenedoresSEND.add(contenedorPatiosDTO);
                        }

                    }
                } else {
                    return contenedoresSEND; // Retorna lista vacia si no se encuentran datos
                }
            }
        }

        if (tipo == 2) {
            String queryEntradas = """
                    SELECT InventarioID FROM inventarioexterno_tbl WHERE ItinerarioID = :itinerarioId AND TipoEvento = 1
                    AND getInventarioIdSalidaIti(ItinerarioID, InventarioID) IS NULL ORDER BY InventarioID DESC LIMIT 1
                    """;
            Query entradasQuery = entityManager.createNativeQuery(queryEntradas);
            entradasQuery.setParameter("itinerarioId", itinerarioId);
            List<Integer> entradas = entradasQuery.getResultList();

            if (!entradas.isEmpty()) {
                for (Integer entrada : entradas) {
                    String querySalida = """
                            SELECT InventarioID FROM inventarioexterno_tbl WHERE AnteriorID = :entrada AND TipoEvento = 2
                            """;
                    Query salidaQuery = entityManager.createNativeQuery(querySalida);
                    salidaQuery.setParameter("entrada", entrada);
                    List<Integer> salidas = salidaQuery.getResultList();

                    if (salidas.isEmpty()) {
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
                                LEFT join rutas_tbl ru ON ru.RutaID = iti.RutaID where iti.itinerarioId = :itinerarioId
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
                                    row[20] != null ? ((Long) row[20]).longValue() : 0L// InventarioID
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
