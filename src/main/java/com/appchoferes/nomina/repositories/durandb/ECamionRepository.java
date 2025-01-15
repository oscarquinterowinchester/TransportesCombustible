package com.appchoferes.nomina.repositories.durandb;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.appchoferes.nomina.models.durandb.ECamionModel;


@Repository
public interface ECamionRepository extends JpaRepository<ECamionModel, Integer>{
    
}
