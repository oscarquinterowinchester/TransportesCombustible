package com.appchoferes.nomina.repositories.lorasdb;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.appchoferes.nomina.models.lorasdb.Chofer;

@Repository
public interface ChoferRepository extends JpaRepository<Chofer, Long> {

    @Query(value = "call getChoferes()", nativeQuery = true)
    List<Chofer> getChoferes();

    // Metodo para recuperar choferes del modulo Patios
    // Se toma la misma clase de Chofer para los modulos de choferes
    // y patios
    @Query(value = "SELECT ChoferID, Nombre FROM choferes_tbl WHERE Status = 1 ORDER BY Nombre", nativeQuery = true)
    List<Chofer> getChoferesPatios();
}
