package com.appchoferes.nomina.repositories.lorasdb;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.appchoferes.nomina.models.lorasdb.VisitorVisitante;

@Repository
public interface VisitorVisitanteRepo extends JpaRepository<VisitorVisitante, Long> {

    @Query(value = "SELECT v.id, v.nombre, v.empresa AS empresaID, v.tipo AS tipo_visitante, 0 AS visto, " +
                   "(SELECT e.nombre FROM visitor_empresas e WHERE e.id = v.empresa) AS empresa, " +
                   "(SELECT t.nombre FROM visitor_tipo_visitantes t WHERE t.id = v.tipo) AS tipo, " +
                   "v.fecha AS last, v.id AS exist, " +
                   "IF(v.foto IS NOT NULL, v.foto, 'img/nopic.png') AS foto, " +
                   "'img/noid.png' AS identificacion " +
                   "FROM visitor_visitantes v " +
                   "WHERE v.id > 0 " +
                   "AND v.id NOT IN (SELECT r.visitanteID FROM visitor_registros r WHERE r.salida IS NULL) " +
                   "AND (:word IS NULL OR v.nombre LIKE %:word%) " +
                   "ORDER BY v.nombre", nativeQuery = true)
    List<Object[]> buscarVisitantes(@Param("word") String word);
}