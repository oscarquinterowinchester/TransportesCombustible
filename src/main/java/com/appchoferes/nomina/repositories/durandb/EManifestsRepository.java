package com.appchoferes.nomina.repositories.durandb;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.appchoferes.nomina.models.durandb.EManifestsModel;

@Repository
public interface EManifestsRepository extends JpaRepository<EManifestsModel, Long>{
    @Query(value = "SELECT * FROM emanifests WHERE status = 1", nativeQuery = true)
    public List<EManifestsModel> findAll();
}
