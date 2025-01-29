package com.appchoferes.nomina.repositories.lorasdb;

import com.appchoferes.nomina.models.lorasdb.Punto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PuntoRepository extends JpaRepository<Punto, Integer> {
    
}