package com.appchoferes.nomina.repositories.lorasdb;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.appchoferes.nomina.models.lorasdb.P_InventarioExterno;

@Repository
public interface InventarioExternoRepository extends JpaRepository<P_InventarioExterno, Integer> {

        @Query(value = "SELECT * FROM inventarioexterno_tbl WHERE Contenedor = :contenedor AND TipoEvento = :tipoEvento ORDER BY InventarioID DESC LIMIT 1", nativeQuery = true)
        List<P_InventarioExterno> findByContenedorAndTipoEvento(@Param("contenedor") String contenedor,
                        @Param("tipoEvento") Integer tipoEvento);

        @Query(value = "SELECT InventarioID FROM inventarioexterno_tbl WHERE ItinerarioID = :itinerarioID AND TipoEvento = 1 AND getInventarioIdSalidaIti(ItinerarioID, InventarioID) IS NULL ORDER BY InventarioID DESC LIMIT 1", nativeQuery = true)
        List<P_InventarioExterno> findEntradaByItinerarioID(@Param("itinerarioID") int itinerarioID);

        @Query(value = "SELECT InventarioID FROM inventarioexterno_tbl WHERE AnteriorID = :anteriorID AND TipoEvento = 2", nativeQuery = true)
        List<P_InventarioExterno> findSalidaByAnteriorID(@Param("anteriorID") int anteriorID);

        @Query(value = "select InventarioID from inventarioexterno_tbl inv where inv.status is true and inv.tipoEvento = 1 "
                        +
                        "and inv.AnteriorID is null and (inv.Contenedor = :contenedor or inv.ItinerarioID = 0) AND " +
                        "(SELECT InventarioID FROM inventarioexterno_tbl WHERE status is true and tipoEvento = 2 " +
                        "AND AnteriorID = inv.InventarioID AND (Contenedor = :contenedor or ItinerarioID = 0)) is null LIMIT 1", nativeQuery = true)
        List<Integer> findEntrada(@Param("contenedor") String contenedor);

}
