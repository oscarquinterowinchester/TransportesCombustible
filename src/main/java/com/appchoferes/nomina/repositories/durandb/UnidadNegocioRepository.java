package com.appchoferes.nomina.repositories.durandb;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.appchoferes.nomina.models.durandb.UnidadNegocioModel;

@Repository
public interface UnidadNegocioRepository extends CrudRepository<UnidadNegocioModel, Integer> {
    List<UnidadNegocioModel> findByStatus(Byte status);

}
