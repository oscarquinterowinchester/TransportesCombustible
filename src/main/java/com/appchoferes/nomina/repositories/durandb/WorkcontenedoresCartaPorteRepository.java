package com.appchoferes.nomina.repositories.durandb;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.appchoferes.nomina.models.durandb.WorkcontenedoresCartaPorteModel;

@Repository
public interface WorkcontenedoresCartaPorteRepository extends JpaRepository<WorkcontenedoresCartaPorteModel, Long> {
    @Query(value="SELECT * FROM workcontenedores_cartaporte wc WHERE wc.WContID = :wcontID", nativeQuery=true)
    List<WorkcontenedoresCartaPorteModel> findByWcontID(Integer wcontID);

    @Query(value="DELETE FROM workcontenedores_cartaporte wc WHERE wc.WContID = :wcontID", nativeQuery=true)
    List<WorkcontenedoresCartaPorteModel> deleteByWcontID(Integer wcontID);


}
