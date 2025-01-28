package com.appchoferes.nomina.repositories.lorasdb;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.appchoferes.nomina.models.lorasdb.PuntosInspeccionInstalaciones;

@Repository
public interface PuntosInspeccionInstRepo extends JpaRepository<PuntosInspeccionInstalaciones, Integer> {

    @Query(value = "SELECT * FROM puntos_inspeccion_instalaciones_tbl WHERE status = 1 ORDER BY id LIMIT 16", nativeQuery = true)
    List<PuntosInspeccionInstalaciones> getPuntosInspeccionInstalaciones();

}
