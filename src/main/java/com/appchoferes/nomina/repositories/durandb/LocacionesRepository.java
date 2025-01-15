package com.appchoferes.nomina.repositories.durandb;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.appchoferes.nomina.models.durandb.LocacionesModel;

@Repository
public interface LocacionesRepository extends JpaRepository<LocacionesModel, Integer> {
    ArrayList<LocacionesModel> findByStatus(int Status);
}
