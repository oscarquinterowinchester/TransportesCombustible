package com.appchoferes.nomina.repositories.durandb;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.appchoferes.nomina.models.durandb.RutasModel;

import java.util.List;

@Repository
public interface RutasRepository extends CrudRepository<RutasModel, Integer> {
    @Query( value = "SELECT * FROM rutas_tbl WHERE Status = true ORDER BY Nombre", nativeQuery = true)
    List<RutasModel> findRutasActivas();
}
