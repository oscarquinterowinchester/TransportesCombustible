package com.appchoferes.nomina.repositories.lorasdb;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.appchoferes.nomina.models.lorasdb.Cliente;

@Repository
public interface ClientesRepository extends JpaRepository<Cliente, Integer> {

    @Query(value = "SELECT NComercial AS nombre, ClienteID AS id " +
            "FROM clientes_tbl " +
            "WHERE Status = true " +
            "AND :tipoId IN (SELECT TipoID " +
            "FROM reltipoc_tbl " +
            "WHERE reltipoc_tbl.ClienteID = clientes_tbl.ClienteID " +
            "AND Status = true) " +
            "ORDER BY NComercial", nativeQuery = true)
    List<Cliente> getClientes(Integer tipoId);
}
