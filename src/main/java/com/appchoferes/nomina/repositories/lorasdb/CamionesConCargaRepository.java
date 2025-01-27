package com.appchoferes.nomina.repositories.lorasdb;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.appchoferes.nomina.models.lorasdb.Camion;

@Repository
public interface CamionesConCargaRepository extends JpaRepository<Camion, Long> {

    @Query(value = "call com_getCamionesTablaDiesel()", nativeQuery = true)
    List<Object[]> getCamionesConCargasRaw();

    @Query(value = "call com_getCamion(:id)", nativeQuery = true)
    List<Object[]> getCamionRaw(@Param("id") Long id);

    // Metodo para recuperar camiones del modulo de combustible
    // recuperacion de datos se hace con id y noEconomico
    @Query(value = "SELECT CamionID, NoEconomico FROM camiones_tbl WHERE Status = 1 ORDER BY NoEconomico", nativeQuery = true)
    List<Object[]> getCamionesPatiosRaw();
}
