package com.appchoferes.nomina.repositories.durandb;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.appchoferes.nomina.models.durandb.CargosClientesModel;


@Repository
public interface CargosClientesRepository extends JpaRepository<CargosClientesModel, Integer> {
    List<CargosClientesModel> findByWContID(Integer WContID);
}
