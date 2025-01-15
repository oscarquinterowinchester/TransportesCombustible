package com.appchoferes.nomina.repositories.durandb;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.appchoferes.nomina.models.durandb.MercanciaConfiguracionModel;

@Repository
public interface MercanciasConfiguracionRepository extends JpaRepository<MercanciaConfiguracionModel, Integer>{
}
