package com.appchoferes.nomina.modules.combustible.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import com.appchoferes.nomina.modules.combustible.models.Proveedor;

@Repository
public interface ProveedorRepository extends JpaRepository<Proveedor, Long> {

    @Procedure(name = "getProveedores")
    List<Proveedor> getProveedores();
}
