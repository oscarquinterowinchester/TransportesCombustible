package com.appchoferes.nomina.repositories.durandb;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.appchoferes.nomina.models.durandb.WconticpModel;

@Repository
public interface WconticpRepository extends JpaRepository<WconticpModel, Integer> {
    Optional<WconticpModel> findByWcontID(Integer wcontID);

    ArrayList<WconticpModel> findByStatus(int Status);

    @Query(value = "SELECT * FROM wconticp_tbl wc WHERE wc.CartaPorteID = :id", nativeQuery = true)
    WconticpModel findByCartaPorteID(Integer id);
}
