package com.appchoferes.nomina.repositories.durandb;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.appchoferes.nomina.models.durandb.TipoCambioModel;

@Repository
public interface TipoCambioRepository extends CrudRepository<TipoCambioModel, Integer> {

@Query(value = "select * from tipocambio_tbl WHERE Fecha = :fecha and Status  = true limit 1", nativeQuery = true)
TipoCambioModel findByFecha(Date fecha);

@Query(value = "select CambioID, TipoCambio,Fecha,DATE_FORMAT(FechaRegistro, \"%Y-%m-%d %H:%i:%s\") as FechaRegistro,UsuarioID, Status, \n" + //
        "(SELECT Nombre FROM usuarios_tbl uu where uu.UsuarioID = tc.UsuarioID) as NombreUsuario,CASE WHEN DATE_FORMAT(Now(),\"%Y-%m-%d\") = Fecha THEN 1 ELSE 0 END as validoEliminar FROM tipocambio_tbl tc WHERE Status = 1 ORDER BY Fecha DESC", nativeQuery = true)
        List<Object[]> obtenerTodoComoArray();

}
