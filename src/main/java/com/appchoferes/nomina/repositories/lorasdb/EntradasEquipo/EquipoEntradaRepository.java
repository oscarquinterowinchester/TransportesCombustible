package com.appchoferes.nomina.repositories.lorasdb.EntradasEquipo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.appchoferes.nomina.models.lorasdb.Contenedor;

@Repository
public interface EquipoEntradaRepository extends JpaRepository<Contenedor, Integer> {

      @Query(value = "CALL getInfoEntradaEquipo(:itinerarioID, :patioID, :fecha)", nativeQuery = true)
      List<Object[]> getInfoEntradaEquipo(
                  @Param("itinerarioID") Long itinerarioId,
                  @Param("patioID") Integer patioId,
                  @Param("fecha") LocalDate fecha);

      @Query(value = "CALL getCheckEntrada(:CamionID, :PatioID)", nativeQuery = true)
      List<Object[]> getCheckEntrada(
                  @Param("CamionID") Integer camionId,
                  @Param("PatioID") Integer patioId);

      @Query(value = """
                  SELECT InspeccionID as id, ListadoID, ItinerarioID,
                        (SELECT Nombre from listadoinspecciones_tbl where listadoinspecciones_tbl.ListadoID = inspecciones_tbl.ListadoID) as concepto, Bien2
                        FROM inspecciones_tbl
                        WHERE ItinerarioID = :itinerarioId
                  """, nativeQuery = true)
      List<Object[]> getInspeccionEntrada(@Param("itinerarioId") Long itinerarioId);
}
