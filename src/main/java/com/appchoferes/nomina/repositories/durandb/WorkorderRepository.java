package com.appchoferes.nomina.repositories.durandb;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.appchoferes.nomina.models.durandb.WorkorderModel;

@Repository
public interface WorkorderRepository extends JpaRepository<WorkorderModel, Integer> {
    @Query("SELECT w FROM WorkorderModel w WHERE w.Status = true and w.clienteID = :clienteID")
    List<WorkorderModel> findByClienteID(@Param("clienteID") Integer clienteID);
}
