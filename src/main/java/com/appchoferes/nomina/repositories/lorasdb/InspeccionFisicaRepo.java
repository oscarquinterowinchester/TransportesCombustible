package com.appchoferes.nomina.repositories.lorasdb;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.appchoferes.nomina.models.lorasdb.InspeccionFisica;

@Repository
public interface InspeccionFisicaRepo extends JpaRepository<InspeccionFisica, Integer> {

    /*
     * @Query("SELECT i FROM InspeccionFisica i WHERE i.guardia = :Guardia AND DATE(i.fecha) = :fecha"
     * )
     * List<InspeccionFisica> findByGuardiaAndFecha(@Param("Guardia") Integer
     * guardia, @Param("fecha") Date fecha);
     */

    InspeccionFisica findByGuardiaAndFecha(int guardia, Date fecha);

}
