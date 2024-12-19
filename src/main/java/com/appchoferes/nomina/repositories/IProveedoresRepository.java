package com.appchoferes.nomina.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.appchoferes.nomina.dtos.ProveedoresCombustible;

public interface IProveedoresRepository extends JpaRepository<ProveedoresCombustible,Long>{

    @Query(value = "CALL `PROVEEDORES_COMBUSTIBLE_SP`();",nativeQuery = true)
    public List<ProveedoresCombustible> getProveedoresCombustible();

}

