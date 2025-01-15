package com.appchoferes.nomina.repositories.durandb;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.appchoferes.nomina.models.durandb.TarifasPagoModel;

@Repository
public interface TarifasPagoRepository extends CrudRepository<TarifasPagoModel, Integer> {

}
