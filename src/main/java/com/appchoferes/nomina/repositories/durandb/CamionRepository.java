package com.appchoferes.nomina.repositories.durandb;

import java.util.ArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.appchoferes.nomina.models.durandb.CamionModel;


@Repository
public interface CamionRepository extends JpaRepository<CamionModel, Integer> {

    @Query( value = "SELECT * FROM camiones_tbl WHERE Status = true ORDER BY NoEconomico", nativeQuery = true)
    ArrayList<CamionModel> findCamionesActivos();

    ArrayList<CamionModel> findByStatus(int Status);
}
