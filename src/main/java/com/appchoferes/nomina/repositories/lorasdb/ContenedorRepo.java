package com.appchoferes.nomina.repositories.lorasdb;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.appchoferes.nomina.models.lorasdb.Contenedor;

@Repository
public interface ContenedorRepo extends JpaRepository<Contenedor, Integer> {
    
        // Consulta nativa para obtener el InventarioID
    @Query(value = "SELECT InventarioID FROM inventarioexterno_tbl " +
                   "WHERE contenedor = :contenedor AND TipoEvento = 1 AND STATUS IS TRUE " +
                   "AND getInventarioIdSalida(contenedor, InventarioID) IS NULL " +
                   "ORDER BY InventarioID DESC LIMIT 1", nativeQuery = true)
    List<Map<String, Object>> findInventarioIdByContenedor(@Param("contenedor") String contenedor);

    // Consulta nativa para obtener el ItinerarioID
    @Query(value = "SELECT getItinerarioRemolque(:contenedor) as ItinerarioID;", nativeQuery = true)
    List<Map<String, Object>> findItinerarioIdByContenedor(@Param("contenedor") String contenedor);

    // Consulta nativa para obtener información de entrada
    @Query(value = "CALL getInformacionEntrada(:itinerarioId)", nativeQuery = true)
    List<Map<String, Object>> getInformacionEntrada(@Param("itinerarioId") Long itinerarioId);

    // Consulta nativa para obtener el InventarioID por ItinerarioID
    @Query(value = "SELECT InventarioID FROM inventarioexterno_tbl " +
                   "WHERE ItinerarioID = :itinerarioId AND TipoEvento = 1 " +
                   "AND getInventarioIdSalidaIti(ItinerarioID, InventarioID) IS NULL " +
                   "ORDER BY InventarioID DESC LIMIT 1", nativeQuery = true)
    List<Map<String, Object>> findInventarioIdByItinerarioId(@Param("itinerarioId") Long itinerarioId);

    @Query(value = "SELECT InventarioID, ItinerarioID FROM inventarioexterno_tbl " +
               "WHERE contenedor = :contenedor AND TipoEvento = 1 AND STATUS IS TRUE " +
               "AND getInventarioIdSalida(contenedor, InventarioID) IS NULL " +
               "ORDER BY InventarioID DESC LIMIT 1", nativeQuery = true)
List<Map<String, Object>> findInventarioIdAndItinerarioIdByContenedor(@Param("contenedor") String contenedor);

}
