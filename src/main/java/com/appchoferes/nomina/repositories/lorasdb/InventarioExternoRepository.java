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

        @Query(value = "SELECT IFNULL(InventarioID, 0) AS inventarioId FROM inventarioexterno_tbl \n" + //
                                "WHERE status IS TRUE AND tipoEvento = :tipoEvento AND AnteriorID = 0 AND \n" + //
                                "(Contenedor = :contenedor AND ItinerarioID = 10) \n" + //
                                "AND (\n" + //
                                "    SELECT InventarioID \n" + //
                                "    FROM inventarioexterno_tbl\n" + //
                                "    WHERE status IS TRUE \n" + //
                                "    AND tipoEvento = :tipoEvento \n" + //
                                "    AND AnteriorID = InventarioID \n" + //
                                "    AND (Contenedor = :contenedor AND ItinerarioID = 10)\n" + //
                                ") IS NULL LIMIT 1;", nativeQuery = true)
        List<Integer> findEntrada(@Param("contenedor") String contenedor , Integer tipoEvento);

}
