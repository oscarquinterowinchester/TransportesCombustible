package com.appchoferes.nomina.repositories.lorasdb;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.appchoferes.nomina.models.lorasdb.Chofer;

@Repository
public interface ColaboradorRepository extends JpaRepository<Chofer, Long> {

    @Query(value = """
        SELECT 
            c.ChoferID as id, 
            c.Nombre as nombre, 
            c.NoEmpleado as noEmpleado,
            NOW() as ahorita,
            IF(c.Telefono = 'NONE', '0', c.Telefono) AS telefono, 
            IFNULL((SELECT res.id FROM registro_entradas_salidas_tbl res WHERE res.ChoferID = c.ChoferID AND res.Fecha = :date), false) as entrada,
            (SELECT p.Nombre FROM puestos_tbl p WHERE p.PuestoID = c.Puesto) AS area, 
            'No definido' as puesto 
        FROM 
            choferes_tbl AS c
        WHERE 
            c.Status = true
            AND (c.Nombre LIKE %:palabra% OR (c.NoEmpleado = :palabra AND c.NoEmpleado != ''))
            AND (SELECT res.FechaSalida FROM registro_entradas_salidas_tbl res WHERE res.ChoferID = c.ChoferID AND res.Fecha = :date) IS NULL
        """, nativeQuery = true)
    List<Object[]> findColaborador(@Param("palabra") String palabra, @Param("date") String date);
}