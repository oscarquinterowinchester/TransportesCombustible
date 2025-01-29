package com.appchoferes.nomina.repositories.lorasdb;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.appchoferes.nomina.models.lorasdb.InventarioExterno;

@Repository
public interface InventarioExternoRepo extends JpaRepository<InventarioExterno, Integer>{

    Boolean existsByContenedorAndItinerarioId(String contenedor, Integer itinerarioId);
}

