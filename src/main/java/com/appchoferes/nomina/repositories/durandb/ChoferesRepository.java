package com.appchoferes.nomina.repositories.durandb;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.appchoferes.nomina.models.durandb.ChoferesModel;


@Repository
public interface ChoferesRepository extends JpaRepository<ChoferesModel, Integer> {
    ArrayList<ChoferesModel> findByStatus(int Status);
}
