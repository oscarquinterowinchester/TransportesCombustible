package com.appchoferes.nomina.repositories.lorasdb;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.appchoferes.nomina.models.lorasdb.ListadoInspeccion;

@Repository
public interface ListadoInspRepo extends JpaRepository<ListadoInspeccion, Integer> {

    @Query(value = "SELECT Nombre, ListadoID, 0 as Entrada, :itinerarioID as ItinerarioID, NULL as ComentarioEntrada, "
            + "NULL as FotoEntrada FROM listadoinspecciones_tbl WHERE Status = 1", nativeQuery = true)
    List<ListadoInspeccion> obtieneListadoInspeccion(@Param("itinerarioID") int itinerarioID);

}

