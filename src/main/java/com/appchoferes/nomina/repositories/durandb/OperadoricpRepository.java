package com.appchoferes.nomina.repositories.durandb;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.appchoferes.nomina.models.durandb.OperadoricpModel;

@Repository
public interface OperadoricpRepository extends JpaRepository<OperadoricpModel, Integer> {
    Optional<OperadoricpModel> findByICartaID(Integer ICartaID);
}
