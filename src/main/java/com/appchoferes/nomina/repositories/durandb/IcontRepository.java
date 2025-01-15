package com.appchoferes.nomina.repositories.durandb;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.appchoferes.nomina.models.durandb.IcontModel;

@Repository
public interface IcontRepository extends JpaRepository<IcontModel, Integer> {
    Optional<IcontModel> findByItinerarioID(Integer itinerarioID);
}
