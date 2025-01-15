package com.appchoferes.nomina.repositories.durandb;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.appchoferes.nomina.models.durandb.dtos.ItinerariosDTO;


@Repository
public interface ItinerariosDTORepository extends JpaRepository<ItinerariosDTO, Integer> {

}
