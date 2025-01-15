package com.appchoferes.nomina.repositories.durandb;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.appchoferes.nomina.models.durandb.TipoCajasModel;


@Repository
public interface TipoCajasRepository extends CrudRepository<TipoCajasModel, Integer> {

}
