package com.appchoferes.nomina.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.appchoferes.nomina.dtos.CargaDieselEntity;
import com.appchoferes.nomina.dtos.CargasDieselEntityOld;

@Repository
public interface CargasDieselRepository extends JpaRepository<CargaDieselEntity,Long> {
    public  CargaDieselEntity findByCargaId(Integer cargaId);

    @Query(value = "SELECT obtenerUltimoOdometroCarga(:unidadId, :tipoUnidad, :tipoOperacion) FROM dual", nativeQuery = true)
    public String obtenerUltimoOdometro(String unidadId, Integer tipoUnidad, Integer tipoOperacion);
    //TipoOperacion 0 para insert, 1 para update

    @Query(value = "SELECT obtenerUltimaFechaCargaCombustible(:unidadId, :tipoUnidad, :tipoOperacion) FROM dual", nativeQuery = true)
    public String obtenerUltimaFecha(String unidadId, int tipoUnidad, int tipoOperacion);

    @Query(value = "SELECT esPrimerRegistro_Combustible(:unidadId, :tipo) FROM dual", nativeQuery = true)
    public boolean esPrimerRegistro(Integer unidadId, Integer tipo);

    public void save(CargasDieselEntityOld carga);
    
}
