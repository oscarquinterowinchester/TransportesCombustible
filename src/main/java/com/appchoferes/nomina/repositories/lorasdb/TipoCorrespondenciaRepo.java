package com.appchoferes.nomina.repositories.lorasdb;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.appchoferes.nomina.models.lorasdb.TipoCorrespondencia;

@Repository
public interface TipoCorrespondenciaRepo extends JpaRepository<TipoCorrespondencia, Integer> {
    @Query(value = "select * from tiposcorrespondencia_tbl", nativeQuery = true)
    List<TipoCorrespondencia> getTiposCorrespondencia();

}
