package com.appchoferes.nomina.repositories.lorasdb;

import org.springframework.data.jpa.repository.JpaRepository;

import com.appchoferes.nomina.models.lorasdb.Vehiculo;

public interface VehiculoRepo extends JpaRepository<Vehiculo, Integer> {
    
}
