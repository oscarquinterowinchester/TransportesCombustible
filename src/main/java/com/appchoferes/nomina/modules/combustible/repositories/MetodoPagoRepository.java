package com.appchoferes.nomina.modules.combustible.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.appchoferes.nomina.models.MetodosPago;

@Repository
public interface MetodoPagoRepository extends JpaRepository<MetodosPago, Integer> {

    @Query(value = "call getMetodosPago()", nativeQuery = true)
    List<Object[]> getMetodosPagoRaw();

}
