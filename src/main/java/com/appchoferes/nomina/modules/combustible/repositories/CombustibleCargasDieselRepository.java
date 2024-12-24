package com.appchoferes.nomina.modules.combustible.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.appchoferes.nomina.dtos.CargasDiesel;

@Repository
public interface CombustibleCargasDieselRepository extends JpaRepository<CargasDiesel, Long> {

    @Query(value = "call com_getCombustibleHistorial(:id, :tipo)", nativeQuery = true)
    List<Object []> getHistorialCargasRaw(Long id, Integer tipo);
}
