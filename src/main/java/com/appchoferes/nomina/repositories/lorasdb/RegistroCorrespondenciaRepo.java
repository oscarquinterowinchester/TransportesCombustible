package com.appchoferes.nomina.repositories.lorasdb;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.appchoferes.nomina.models.lorasdb.RegistroCorrespondencia;

@Repository
public interface RegistroCorrespondenciaRepo extends JpaRepository<RegistroCorrespondencia, Integer> {

    @Query(value = "SELECT * FROM registroscorrespondencias_tbl WHERE TRIM(firma) = ''", nativeQuery = true)
    List<RegistroCorrespondencia> getRegistrosC();
}
