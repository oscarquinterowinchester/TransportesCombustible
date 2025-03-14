package com.appchoferes.nomina.repositories.lorasdb;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.appchoferes.nomina.models.lorasdb.P_InventarioExterno;

import jakarta.transaction.Transactional;

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

        @Query(value = "SELECT getItinerarioRemolque(:contenedor) as ItinerarioID", nativeQuery = true)
        Integer getItinerarioRemolque(@Param("contenedor") String contenedor);

        @Query(value = "CALL getInformacionSalida(:itinerarioID)", nativeQuery = true)
        List<Object[]> getInformacionSalida(@Param("itinerarioID") int itinerarioID);

        @Query(value = "CALL getDatosInventarioExterno(:inventarioID)", nativeQuery = true)
        List<Object[]> getDatosInventarioExterno(@Param("inventarioID") int inventarioID);

        @Query(value = "CALL getDatosSalidaComplejo(:itinerarioID)", nativeQuery = true)
        List<Object[]> getDatosSalidaComplejo(@Param("itinerarioID") int itinerarioID);

        @Query(value = "CALL getDatosConEntrada(:itinerarioID)", nativeQuery = true)
        List<Object[]> getDatosConEntrada(@Param("itinerarioID") int itinerarioID);

        @Transactional
        @Modifying
        @Query(value = "UPDATE inventarioexterno_tbl " +
                        "SET FotoSello = :fotoSello, " +
                        "FirmaGuardia = :firmaGuardia, " +
                        "FirmaChofer = :firmaChofer, " +
                        "FirmaK9 = :firmak9 " +
                        "WHERE InventarioID = :inventarioId", nativeQuery = true)
        void actualizarInventario(
                        @Param("fotoSello") String fotoSello,
                        @Param("firmaGuardia") String firmaGuardia,
                        @Param("firmaChofer") String firmaChofer,
                        @Param("firmak9") String firmak9,
                        @Param("inventarioId") Integer inventarioId);

        @Transactional
        @Modifying
        @Query(value = "UPDATE inventarioexterno_tbl " +
                        "SET FirmaK9 = :firmaK9 " +
                        "WHERE InventarioID = :inventarioId", nativeQuery = true)
        void actualizarInventarioSalida(
                        @Param("firmaK9") String firmaK9,
                        @Param("inventarioId") Integer inventarioId);

}
