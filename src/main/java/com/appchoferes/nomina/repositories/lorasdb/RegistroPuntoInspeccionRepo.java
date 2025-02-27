package com.appchoferes.nomina.repositories.lorasdb;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.appchoferes.nomina.models.lorasdb.RegistroPuntoInspeccion;

@Repository
public interface RegistroPuntoInspeccionRepo extends JpaRepository<RegistroPuntoInspeccion, Integer> {

    @Query(value = """
                SELECT
            WEEKDAY(fecha_registro) AS dia_semana,
            HOUR(fecha_registro) AS hora,
            GROUP_CONCAT(id) AS ids,
            GROUP_CONCAT(punto) AS puntos,
            GROUP_CONCAT(estado) AS estados
            FROM
                registros_puntos_inspeccion_tbl
            WHERE
                fecha_registro >= CURDATE() - INTERVAL (DAYOFWEEK(CURDATE()) - 2) DAY
                AND fecha_registro < CURDATE() + INTERVAL (8 - DAYOFWEEK(CURDATE())) DAY
            GROUP BY
                dia_semana, hora
            ORDER BY
                dia_semana, hora
                """, nativeQuery = true)
    List<Object[]> findPuntosSemana();

    @Query(value = """
                SELECT
                    DISTINCT(:id_guardia) as id, Nombre as nombre
                FROM
                    registros_puntos_inspeccion_tbl, usuarios_tbl
                WHERE
                    fecha_registro >= CURDATE() - INTERVAL (DAYOFWEEK(CURDATE()) - 2) DAY
                    AND fecha_registro < CURDATE() + INTERVAL (8 - DAYOFWEEK(CURDATE())) DAY
                    AND usuarios_tbl.UsuarioID = :id_guardia;
            """, nativeQuery = true)
    List<Object[]> findGuardiasConRegistroEnLaSemana(@Param("id_guardia") Integer id_guardia);
}
