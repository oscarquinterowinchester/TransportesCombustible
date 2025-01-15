package com.appchoferes.nomina.repositories.durandb;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.appchoferes.nomina.models.durandb.EstadosModel;


@Repository
public interface EstadosRepository extends JpaRepository<EstadosModel, Integer> {
List<EstadosModel> findByPaisID(Integer PaisID);
}
