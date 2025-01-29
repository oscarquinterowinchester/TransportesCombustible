package com.appchoferes.nomina.repositories.lorasdb;

import org.springframework.data.jpa.repository.JpaRepository;

import com.appchoferes.nomina.models.lorasdb.Contenedor;

public interface ContenedorRepo extends JpaRepository<Contenedor, Integer> {
    
}
