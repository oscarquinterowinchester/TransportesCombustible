package com.appchoferes.nomina.modules.combustible.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.appchoferes.nomina.modules.combustible.models.CargaDiesel;

@Repository
public interface CombustibleCargasDieselRepository extends JpaRepository<CargaDiesel, Long> {

    @Query(value = "call com_getCombustibleHistorial(:id, :tipo)", nativeQuery = true)
    List<Object []> getHistorialCargas(Long id, Integer tipo);

    @Query(value = "call com_getHistorialAnterior(:id, :fechaActual)", nativeQuery = true)
    List<Object []> getHistorialAnterior(Long id, String fechaActual);
}
