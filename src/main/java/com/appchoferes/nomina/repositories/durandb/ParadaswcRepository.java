package com.appchoferes.nomina.repositories.durandb;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.appchoferes.nomina.models.durandb.ParadaswcModel;


@Repository
public interface ParadaswcRepository extends JpaRepository<ParadaswcModel, Integer> {
    // @Modifying
    // @Transactional
    // @Query("UPDATE ParadaswcModel p SET p.status = 0 WHERE p.wcontfk = :wcid AND
    // p.ruta = 1")
    // void updateStatusForWcid(@Param("wcid") Integer wcid);
@Query("SELECT pw FROM ParadaswcModel pw WHERE pw.wcontfk = :wcontID")
    ArrayList<ParadaswcModel> findParadasbywcontID(Integer wcontID);

    @Query(value="DELETE FROM paradaswc_tbl WHERE wcontfk = :wcontID", nativeQuery=true)
    Optional<ParadaswcModel> deleteBywcontfk(Integer wcontID);

    @Query( value = "SELECT p.*,\n" + //
                "(SELECT Nombre FROM tipoparada_tbl tp WHERE tp.id = p.tipop ) as TipoParada,\n" + //
                "(loc.Nombre) as Nombre, \n" + //
                "concat(loc.Direccion,' #',loc.NoExterior,CASE WHEN loc.Municipio is null THEN '' ELSE CONCAT(' ',loc.Municipio) END,CASE WHEN loc.Estado is null THEN '' ELSE CONCAT(' ',loc.Estado) END,CASE WHEN loc.Pais is null THEN '' ELSE CONCAT(' ',loc.Pais) END,CASE WHEN loc.cp is null THEN '' ELSE CONCAT(' CP ',loc.cp) END) as Direccion\n" + //
                "FROM paradaswc_tbl p \n" + //
                "LEFT JOIN locaciones_tbl loc ON loc.LocacionID = p.locacionfk\n" + //
                "WHERE wcontfk = :wcontID ORDER BY Orden ASC", nativeQuery = true)
    List<ParadaswcModel> findParadas(Integer wcontID);
    
}
