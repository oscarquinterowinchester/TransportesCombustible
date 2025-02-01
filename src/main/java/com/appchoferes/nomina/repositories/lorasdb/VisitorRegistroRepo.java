package com.appchoferes.nomina.repositories.lorasdb;

import com.appchoferes.nomina.models.lorasdb.VisitorRegistro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface VisitorRegistroRepo extends JpaRepository<VisitorRegistro, Integer> {

    @Query(value = """
        SELECT 
            r.*, 
            IFNULL(v.foto, 'img/nopic.png') AS foto, 
            v.firma, 
            v.identificacion,
            v.identificacion2,
            e.nombre AS compania,
            0 AS completado 
        FROM visitor_registros r 
        LEFT JOIN visitor_visitantes v ON r.visitanteID = v.id
        LEFT JOIN visitor_empresas e ON v.empresa = e.id
        WHERE r.id IS NOT NULL
        AND (:id IS NULL OR r.id = :id)
        AND (:inicio IS NULL OR r.fecha >= CONCAT(:inicio, ' 00:00:00'))
        AND (:final IS NULL OR r.fecha <= CONCAT(:final, ' 23:59:59'))
        ORDER BY r.nombre
        """, nativeQuery = true)
    List<Object[]> findRegistrosHistorial(
        @Param("id") Integer id,
        @Param("inicio") String inicio,
        @Param("final") String fin
    );
}