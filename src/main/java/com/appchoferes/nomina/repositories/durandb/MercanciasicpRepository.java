package com.appchoferes.nomina.repositories.durandb;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.appchoferes.nomina.models.durandb.MercanciaicpModel;


@Repository
public interface MercanciasicpRepository extends JpaRepository<MercanciaicpModel, Integer> {
    List<MercanciaicpModel> findByICartaID(Integer ICartaID);
}
