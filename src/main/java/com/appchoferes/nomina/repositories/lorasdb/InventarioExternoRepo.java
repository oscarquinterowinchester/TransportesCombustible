package com.appchoferes.nomina.repositories.lorasdb;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.appchoferes.nomina.models.lorasdb.InventarioExterno;

@Repository
public interface InventarioExternoRepo extends JpaRepository<InventarioExterno, Integer>{

    Boolean existsByContenedorAndItinerarioId(String contenedor, Integer itinerarioId);

    @Query(value = "SELECT InventarioID, ItinerarioID, Contenedor, NULLIF(FechaEvento, '0000-00-00 00:00:00') AS FechaEvento FROM inventarioexterno_tbl WHERE contenedor = :contenedor AND TipoEvento = :tipoEvento ORDER BY InventarioID DESC LIMIT 1", nativeQuery = true)
    List<InventarioExterno> findByContenedorAndTipoEvento(@Param("contenedor") String contenedor, @Param("tipoEvento") int tipoEvento);
}

