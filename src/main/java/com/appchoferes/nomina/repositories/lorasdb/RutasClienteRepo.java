package com.appchoferes.nomina.repositories.lorasdb;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.appchoferes.nomina.models.lorasdb.Ruta;

@Repository
public interface RutasClienteRepo extends JpaRepository<Ruta, Long> {

    @Query(value = "SELECT RutaID as id, Nombre as nombre, Status FROM rutas_tbl WHERE"
            + " ClienteID = :clienteID AND Status = 1 order by Origen", nativeQuery = true)
    List<Object[]> getRutaClienteRaw(@Param("clienteID") Long clienteID);

}
