package com.appchoferes.nomina.repositories.lorasdb;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.appchoferes.nomina.models.lorasdb.MetodoPago;

@Repository
public interface MetodoPagoRepository extends JpaRepository<MetodoPago, Integer> {

    @Query(value = "call getMetodosPago()", nativeQuery = true)
    List<Object[]> getMetodosPagoRaw();

}
