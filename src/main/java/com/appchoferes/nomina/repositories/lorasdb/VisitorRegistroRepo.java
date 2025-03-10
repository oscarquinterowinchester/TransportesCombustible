package com.appchoferes.nomina.repositories.lorasdb;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.appchoferes.nomina.models.lorasdb.VisitorRegistro;

@Repository
public interface VisitorRegistroRepo extends JpaRepository<VisitorRegistro, Long> {

        // getRegistrosPendientes()
        @Query(value = "SELECT r.*, IFNULL(v.foto, 'img/nopic.png') AS foto, " +
                        "v.firma, " +
                        "v.identificacion, " +
                        "v.identificacion2, " +
                        "e.nombre AS compania, " +
                        "0 AS completado  " +
                        "FROM visitor_registros r " +
                        "LEFT JOIN visitor_visitantes v ON r.visitanteID = v.id " +
                        "LEFT JOIN visitor_empresas e ON v.empresa = e.id " +
                        "WHERE r.salida IS NULL " +
                        "ORDER BY id desc " +
                        "LIMIT 10", nativeQuery = true)
        List<Object[]> findRegistrosPendientes(
                        @Param("id") Long id,
                        @Param("inicio") LocalDateTime inicio,
                        @Param("final") LocalDateTime finalDate);

        // getRegistrosHistorial ()
        @Query(value = "SELECT " +
                        "r.id, r.fecha, r.entrada, r.asunto, r.visitanteID, r.gafete, r.vehiculo, r.salida, r.empleado, r.duracion, r.archivoGenerado, "
                        +
                        "IFNULL(v.foto, 'img/nopic.png') AS foto, " +
                        "v.firma, v.identificacion, v.identificacion2, " +
                        "e.nombre AS compania, " +
                        "0 AS completado, " +
                        "v.nombre AS nombreVisitante " + // Agregar el nombre del visitante
                        "FROM visitor_registros r " +
                        "LEFT JOIN visitor_visitantes v ON r.visitanteID = v.id " +
                        "LEFT JOIN visitor_empresas e ON v.empresa = e.id " +
                        "WHERE r.id IS NOT NULL " +
                        "AND (:id IS NULL OR r.id = :id) " + // Condición del id
                        "AND (:inicio IS NULL OR r.fecha >= :inicio) " + // Condición de fecha de inicio
                        "AND (:finalDate IS NULL OR r.fecha <= :finalDate) " + // Condición de fecha de fin
                        "ORDER BY v.nombre", nativeQuery = true) // Ordenar por nombre del visitante
        List<Object[]> findRegistrosHistorial(
                        @Param("id") Long id,
                        @Param("inicio") LocalDateTime inicio,
                        @Param("finalDate") LocalDateTime finalDate);
}