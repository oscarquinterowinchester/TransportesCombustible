package com.appchoferes.nomina.repositories.lorasdb;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.appchoferes.nomina.models.lorasdb.VisitorVisitante;

import jakarta.transaction.Transactional;

@Repository
public interface VisitorVisitanteRepo extends JpaRepository<VisitorVisitante, Long> {

    @Transactional
    @Modifying
    @Query(value = "UPDATE visitor_visitantes v SET v.foto = :fotoPath WHERE v.id = :id", nativeQuery = true)
    void updateFoto(@Param("fotoPath") String fotoPath, @Param("id") Long id);

    @Transactional
    @Modifying
    @Query(value = "UPDATE visitor_visitantes v SET v.firma = :firmaPath WHERE v.id = :id", nativeQuery = true)
    void updateFirma(@Param("firmaPath") String firmaPath, @Param("id") Long id);

    @Transactional
    @Modifying
    @Query(value = "UPDATE visitor_visitantes v SET v.identificacion = :identificacionPath WHERE v.id = :id", nativeQuery = true)
    void updateIdentificacion(@Param("identificacionPath") String identificacionPath, @Param("id") Long id);

    @Transactional
    @Modifying
    @Query(value = "UPDATE visitor_visitantes v SET v.identificacion2 = :identificacion2Path WHERE v.id = :id", nativeQuery = true)
    void updateIdentificacion2(@Param("identificacion2Path") String identificacion2Path, @Param("id") Long id);
}
