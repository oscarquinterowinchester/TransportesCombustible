package com.appchoferes.nomina.repositories.lorasdb;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.appchoferes.nomina.models.lorasdb.EmpresaModel;

@Repository
public interface EmpresaRepository extends JpaRepository<EmpresaModel, Integer> {

    @Query(value = "SELECT * FROM empresas_tbl WHERE EmpresaID = :id", nativeQuery = true)
    EmpresaModel seleccionarEmpresa(Integer id);

}
