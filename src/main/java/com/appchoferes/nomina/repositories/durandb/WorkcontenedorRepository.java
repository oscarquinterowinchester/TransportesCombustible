package com.appchoferes.nomina.repositories.durandb;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.appchoferes.nomina.models.durandb.WorkcontenedorModel;

@Repository
public interface WorkcontenedorRepository extends CrudRepository<WorkcontenedorModel, Integer> {
    @Query( value = "SELECT * FROM workcontenedores_tbl WHERE Status = true ORDER BY WContenedorID DESC LIMIT 20", nativeQuery = true)
    List<WorkcontenedorModel> findWorkContenedores();

    @Query( value = "SELECT getFacDescripcionFull('0', true, :wcont1, :wcont2)", nativeQuery = true)
    String obtenerDescription(Integer wcont1, Integer wcont2);


    @Query( value = " SELECT objimprt from rutas_tbl left join workcontenedores_tbl on rutas_tbl.RutaID = workcontenedores_tbl.RutaID where WContenedorID = :wcont1", nativeQuery = true)
    String obtenerObjImp(Integer wcont1);

    @Query( value = " SELECT ROUND(IVArt*100,4) from rutas_tbl left join workcontenedores_tbl on rutas_tbl.RutaID = workcontenedores_tbl.RutaID where WContenedorID = :wcont1", nativeQuery = true)
    Double obtenerIVA(Integer wcont1);

    @Query( value = " SELECT ROUND(IVARETrt*100,4) from rutas_tbl left join workcontenedores_tbl on rutas_tbl.RutaID = workcontenedores_tbl.RutaID where WContenedorID = :wcont1", nativeQuery = true)
    Double obtenerIVARET(Integer wcont1);

    @Query( value = "SELECT FORMAT(IFNULL(IF(MonedaCliente = :monedacliente, CobroCliente,IF(:monedacliente  = 0, :CobroClienteMult , :CobroClienteDiv) ),0)+IFNULL((SELECT IFNULL(IF(wc.MonedaCliente = :monedacliente , wc.CobroCliente,IF(:monedacliente = 0, wc.CobroCliente*:tipoCambio, wc.CobroCliente/:tipoCambio) ),0) from workcontenedores_tbl as wc where wc.WContenedorID = :wcont),0),2) from workcontenedores_tbl  as ico where ico.WContenedorID = :wcont", nativeQuery = true)
    Double obtenerImporte(Double CobroClienteMult, Double CobroClienteDiv, Double tipoCambio, Integer wcont, Integer monedacliente);
}
