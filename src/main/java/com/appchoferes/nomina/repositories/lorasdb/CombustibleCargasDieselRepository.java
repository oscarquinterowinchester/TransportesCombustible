package com.appchoferes.nomina.repositories.lorasdb;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.appchoferes.nomina.models.lorasdb.CargaDiesel;

import jakarta.transaction.Transactional;

@Repository
public interface CombustibleCargasDieselRepository extends JpaRepository<CargaDiesel, Long> {

    @Query(value = "call com_getCombustibleHistorial(:id, :tipo)", nativeQuery = true)
    List<Object[]> getHistorialCargas(Long id, Integer tipo);

    @Query(value = "call com_getHistorialAnterior(:id, :fechaActual)", nativeQuery = true)
    List<Object[]> getHistorialAnterior(Long id, String fechaActual);

    @Query(value = "call com_insertarCargaDiesel(:cargaDiesel); select * from cargasdiesel_tbl where CargaID = LAST_INSERT_ID();", nativeQuery = true)
    @Modifying
    @Transactional
    CargaDiesel insertarCargaDiesel(@Param("cargaDiesel") CargaDiesel cargaDiesel);

    @Transactional
    @Modifying
    @Query(value = "UPDATE cargasdiesel_tbl SET FotoTanque1 = :fotoTanque1, FotoTanque2 = :fotoTanque2, " +
            "Firma = :firma, FotoOdometro = :fotoOdometro, FotoSello = :fotoSello " +
            "WHERE CargaID = :cargaId", nativeQuery = true)
    void actualizarImagenes(@Param("cargaId") Long cargaId,
            @Param("fotoTanque1") String fotoTanque1,
            @Param("fotoTanque2") String fotoTanque2,
            @Param("firma") String firma,
            @Param("fotoOdometro") String fotoOdometro,
            @Param("fotoSello") String fotoSello);

}
