package com.appchoferes.nomina.repositories.durandb;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.appchoferes.nomina.models.durandb.TipoUnidadModel;


@Repository
public interface TipoUnidadRepository extends CrudRepository<TipoUnidadModel, Integer> {

}
