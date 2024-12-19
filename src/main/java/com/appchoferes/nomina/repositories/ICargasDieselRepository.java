package com.appchoferes.nomina.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.appchoferes.nomina.dtos.CargasDiesel;

@Repository
public interface ICargasDieselRepository extends JpaRepository<CargasDiesel,Long> {
@Query(value = "CALL `CARGAS_DIESEL_SP`(:choferId);",nativeQuery = true)
public List<CargasDiesel> getCargasDiesel(String choferId);
}
