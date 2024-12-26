package com.appchoferes.nomina.modules.combustible.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.appchoferes.nomina.modules.combustible.models.Ruta;

@Repository
public interface KmCamionRepository extends JpaRepository<Ruta, Long> {

    @Query(value = "call com_getKmCamion(:camionId, :fechaAnterior, :fechaActual)", nativeQuery = true)
    List<Object []> getKmCamion(Long camionId, String fechaAnterior, String fechaActual);

}
