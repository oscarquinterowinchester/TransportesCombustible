package com.appchoferes.nomina.repositories.lorasdb;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.appchoferes.nomina.models.lorasdb.VisitorVisitante;

public interface VisitorVisitanteRepo extends JpaRepository<VisitorVisitante, Long> {
   
    @Modifying
    @Query("UPDATE VisitorVisitante v SET v.firma = :firmaPath WHERE v.id = :id")
    void updateFirma(@Param("firmaPath") String firmaPath, @Param("id") Long id);
}
