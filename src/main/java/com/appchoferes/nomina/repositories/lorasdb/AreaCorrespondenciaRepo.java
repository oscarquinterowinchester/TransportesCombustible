package com.appchoferes.nomina.repositories.lorasdb;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.appchoferes.nomina.models.lorasdb.AreaCorrespondencia;

public interface AreaCorrespondenciaRepo extends JpaRepository<AreaCorrespondencia, Integer> {
    @Query(value = "SELECT * FROM areascorrespondencia_tbl", nativeQuery = true)
    List<AreaCorrespondencia> areasCorrespondencia();
}
