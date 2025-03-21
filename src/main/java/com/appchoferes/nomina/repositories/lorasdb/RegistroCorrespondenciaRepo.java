package com.appchoferes.nomina.repositories.lorasdb;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.appchoferes.nomina.models.lorasdb.RegistroCorrespondencia;

import jakarta.transaction.Transactional;

@Repository
public interface RegistroCorrespondenciaRepo extends JpaRepository<RegistroCorrespondencia, Integer> {

    @Query(value = "SELECT * FROM registroscorrespondencias_tbl WHERE TRIM(firma) = ''", nativeQuery = true)
    List<RegistroCorrespondencia> getRegistrosC();

    @Transactional
    @Modifying
    @Query(value = "update registroscorrespondencias_tbl set fechaEntrega = :fechaEntrega, firma = :firma where id = :id", nativeQuery = true)
    void actualizarRegistro(@Param("fechaEntrega") String fechaEntraga, @Param("firma") String firma,
            @Param("id") Integer id);

}
