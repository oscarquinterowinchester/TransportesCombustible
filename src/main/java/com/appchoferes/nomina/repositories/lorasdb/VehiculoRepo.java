package com.appchoferes.nomina.repositories.lorasdb;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.appchoferes.nomina.models.lorasdb.Vehiculo;

@Repository
public interface VehiculoRepo extends JpaRepository<Vehiculo, Integer> {
    List<Vehiculo> findByVisitante(Integer visitante);
    
}
