package com.appchoferes.nomina.modules.combustible.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.appchoferes.nomina.modules.combustible.models.Caja;

@Repository
public interface CajaRepository extends JpaRepository<Caja, Long> {

    @Query(value = "call com_getCajasDiesel()", nativeQuery = true)
    List<Object[]> getCajasConCargasRaw();
    
}
