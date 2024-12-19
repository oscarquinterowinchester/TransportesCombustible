package com.appchoferes.nomina.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.appchoferes.nomina.models.MetodosPago;

@Repository
public interface IMetodosPagoRepository extends JpaRepository<MetodosPago,Long>{
    @Query(value = "CALL `METODOS_PAGO_SP`();",nativeQuery = true)
    public List<MetodosPago> getMetodosPago();
}
