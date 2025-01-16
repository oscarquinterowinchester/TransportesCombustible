package com.appchoferes.nomina.repositories.lorasdb;
import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.appchoferes.nomina.models.lorasdb.Proveedor;

@Repository
public interface ProveedorRepository extends JpaRepository<Proveedor, Long> {

    @Query(value = "call getProveedores()", nativeQuery = true)
    List<Object[]> getProveedoresRaw();
}
