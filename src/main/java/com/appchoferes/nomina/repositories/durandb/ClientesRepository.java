package com.appchoferes.nomina.repositories.durandb;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.appchoferes.nomina.models.durandb.ClientesModel;


@Repository
public interface ClientesRepository extends JpaRepository<ClientesModel, Integer> {
    ArrayList<ClientesModel> findByStatus(int Status);
}
