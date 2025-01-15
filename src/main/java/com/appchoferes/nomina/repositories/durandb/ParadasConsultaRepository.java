package com.appchoferes.nomina.repositories.durandb;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.appchoferes.nomina.models.durandb.ParadasConsultaModel;

@Repository
public interface ParadasConsultaRepository extends JpaRepository<ParadasConsultaModel, Integer> {

    @Query(value = "SELECT p.*, '' as Pais, '' as RFC,'' as codigoSat,'' as KM,    \n" +
            "(SELECT Nombre FROM tipoparada_tbl tp WHERE tp.id = p.tipop ) as TipoParada,\n" + //
            "(loc.Nombre) as Nombre, \n" + //
            "concat(loc.Direccion,' #',loc.NoExterior,CASE WHEN loc.Municipio is null THEN '' ELSE CONCAT(' ',loc.Municipio) END,CASE WHEN loc.Estado is null THEN '' ELSE CONCAT(' ',loc.Estado) END,CASE WHEN loc.Pais is null THEN '' ELSE CONCAT(' ',loc.Pais) END,CASE WHEN loc.cp is null THEN '' ELSE CONCAT(' CP ',loc.cp) END) as Direccion\n"
            +
            "FROM paradaswc_tbl p \n" + //
            "LEFT JOIN locaciones_tbl loc ON loc.LocacionID = p.locacionfk\n" + //
            "WHERE wcontfk = :wcontID ORDER BY Orden ASC", nativeQuery = true)
    ArrayList<ParadasConsultaModel> findParadas(Integer wcontID);

    @Query(value = "SELECT p.*,\n" +
            "(SELECT Nombre FROM tipoparada_tbl tp WHERE tp.id = p.tipop ) as TipoParada,\n" + //
            "(loc.Nombre) as Nombre, \n" +
            "'' as Direccion, \n" +
            "loc.Pais as Pais,\n" +
            "loc.RFCl as RFC,\n" +
            "(SELECT Codigo FROM conceptossatr_tbl WHERE ConceptoID = rut.ConceptoSATID ) as codigoSat,\n" +
            "rut.KM as KM \n" +
            "FROM paradaswc_tbl p \n" +
            "LEFT JOIN locaciones_tbl loc ON loc.LocacionID = p.locacionfk \n" +
            "LEFT JOIN workcontenedores_tbl wcont ON WContenedorID = p.wcontfk \n" +
            "LEFT JOIN rutas_tbl rut ON rut.RutaID = wcont.RutaID \n" +
            "WHERE wcontfk = :wcontID ORDER BY Orden ASC", nativeQuery = true)
    ArrayList<ParadasConsultaModel> findParadascont(Integer wcontID);

}
