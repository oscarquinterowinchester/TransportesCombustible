package com.appchoferes.nomina.repositories.durandb;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.appchoferes.nomina.models.durandb.CuentasPorCobrarModel;

@Repository
public interface CuentasPorCobrarRepository extends JpaRepository<CuentasPorCobrarModel, Integer>{
    @Transactional
    @Modifying
    @Query(value="SELECT * FROM cuentasxcobrar cc WHERE cc.idcliente = :clienteID", nativeQuery = true)
    List<CuentasPorCobrarModel> obtenCuentasPorCobrarByCliente(Integer clienteID);
}
