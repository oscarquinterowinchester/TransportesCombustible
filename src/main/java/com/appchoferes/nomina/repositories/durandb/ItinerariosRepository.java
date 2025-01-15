package com.appchoferes.nomina.repositories.durandb;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.appchoferes.nomina.models.durandb.ItinerariosModel;


@Repository
public interface ItinerariosRepository extends JpaRepository<ItinerariosModel, Integer> {
    List<ItinerariosModel> findTop50ByOrderByStatusAsc();

    @Query(value = "SELECT * FROM itinerarios_tbl as i WHERE i.Status = :Status ORDER BY i.itinerarioID DESC LIMIT 20", nativeQuery = true)
    ArrayList<ItinerariosModel> findByStatusAux(int Status);
    ArrayList<ItinerariosModel> findByStatus(int Status);
}
