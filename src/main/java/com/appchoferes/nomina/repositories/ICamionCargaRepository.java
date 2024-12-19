package com.appchoferes.nomina.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.appchoferes.nomina.dtos.CamionCarga;

@Repository
public interface ICamionCargaRepository extends JpaRepository<CamionCarga,Long> {
    @Query(value = "CALL `VISTA_CAMIONCARGA`(:choferId);", nativeQuery = true)
    public CamionCarga getCamionCarga(String choferId);
}
