package com.appchoferes.nomina.modules.combustible.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.appchoferes.nomina.modules.combustible.models.CombustibleItinerario;

@Repository
public interface CombustibleItinerarioRepository extends JpaRepository<CombustibleItinerario, Long>{

    @Query(value = "call com_getItinerariosCamion(:camionId, :fechaAnterior, :fechaActual)", nativeQuery = true)
    List<Object[]> getItinetariosCamion(Long camionId, String fechaAnterior, String fechaActual);
}
