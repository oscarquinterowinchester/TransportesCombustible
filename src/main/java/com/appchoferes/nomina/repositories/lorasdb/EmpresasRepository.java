package com.appchoferes.nomina.repositories.lorasdb;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.appchoferes.nomina.models.lorasdb.EmpresasModel;

@Repository
public interface EmpresasRepository extends CrudRepository<EmpresasModel, Integer> {

}
