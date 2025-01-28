package com.appchoferes.nomina.repositories.lorasdb;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.appchoferes.nomina.models.lorasdb.EstadosPais;

@Repository
public interface EstadosPaisRepo extends JpaRepository<EstadosPais, Integer> {

    @Query(value = "SELECT EstadoID, Nombre FROM estados_tbl WHERE PaisID = :paisID AND Status = 1", nativeQuery = true)
    List<EstadosPais> getEstadosPais(@Param("paisID") Integer paisID);

}
