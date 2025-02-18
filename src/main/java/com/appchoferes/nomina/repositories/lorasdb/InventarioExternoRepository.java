package com.appchoferes.nomina.repositories.lorasdb;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.appchoferes.nomina.models.lorasdb.P_InventarioExterno;

@Repository
public interface InventarioExternoRepository extends JpaRepository<P_InventarioExterno, Integer> {

        @Query(value = "SELECT InventarioID, ItinerarioID, Contenedor, NULLIF(FechaEvento, '0000-00-00 00:00:00') AS FechaEvento FROM inventarioexterno_tbl WHERE Contenedor = :contenedor AND TipoEvento = :tipoEvento ORDER BY InventarioID DESC LIMIT 1", nativeQuery = true)
        List<P_InventarioExterno> findByContenedorAndTipoEvento(@Param("contenedor") String contenedor,
                        @Param("tipoEvento") Integer tipoEvento);

        @Query(value = "SELECT InventarioID FROM inventarioexterno_tbl WHERE ItinerarioID = :itinerarioID AND TipoEvento = 1 AND getInventarioIdSalidaIti(ItinerarioID, InventarioID) IS NULL ORDER BY InventarioID DESC LIMIT 1", nativeQuery = true)
        List<P_InventarioExterno> findEntradaByItinerarioID(@Param("itinerarioID") int itinerarioID);

        @Query(value = "SELECT InventarioID FROM inventarioexterno_tbl WHERE AnteriorID = :anteriorID AND TipoEvento = 2", nativeQuery = true)
        List<P_InventarioExterno> findSalidaByAnteriorID(@Param("anteriorID") int anteriorID);

        // Asegúrate de que 'Contenedor' esté escrito con la 'C' mayúscula
        // Boolean existsByContenedorAndItinerarioID(String Contenedor, Integer
        // itinerarioID);

}
