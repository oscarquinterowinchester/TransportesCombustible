package com.appchoferes.nomina.repositories.durandb;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.appchoferes.nomina.models.durandb.TarifasucModel;

@Repository
public interface TarifasucRepository extends JpaRepository<TarifasucModel, Integer> {
    List<TarifasucModel> findByRutafk(Integer tarifa);
}
