package com.appchoferes.nomina.repositories.lorasdb;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.appchoferes.nomina.models.lorasdb.Sizes;

@Repository
public interface SizesRepository extends JpaRepository<Sizes, Integer> {

    @Query(value = "SELECT TamanoID, Tamano FROM tamanoremo_tbl WHERE Status = 1", nativeQuery = true)
    List<Sizes> getSizes();

}
