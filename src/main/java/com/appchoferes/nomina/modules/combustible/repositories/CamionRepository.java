package com.appchoferes.nomina.modules.combustible.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

//import com.appchoferes.nomina.modules.combustible.dtos.CamionConCargaDTO;
import com.appchoferes.nomina.modules.combustible.models.Camion;


@Repository
public interface CamionRepository extends JpaRepository<Camion, Long> {

    @Query(value = "call com_getCamionesTablaDiesel()", nativeQuery = true)
    List<Object[]> getCamionesConCargasRaw();

}
