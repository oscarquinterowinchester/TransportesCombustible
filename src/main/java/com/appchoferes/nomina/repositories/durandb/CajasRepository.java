package com.appchoferes.nomina.repositories.durandb;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.appchoferes.nomina.models.durandb.CajasModel;


@Repository
public interface CajasRepository extends CrudRepository<CajasModel, Integer> {
    /*
     * @Query("SELECT CajaID, NoEconomico from cajas_tbl where Status = true order by CAST(NoEconomico as UNSIGNED)"
     * )
     * List<CajasModel> findCajasActivasOrderByNoEconomico();
     *
     * List<CajasModel> findByStatusTrueOrderByNoEconomico();
     */
    @Query("SELECT c FROM CajasModel c WHERE c.Status = true ORDER BY c.NoEconomico")
    List<CajasModel> findCajasActivasOrderByNoEconomico();
}
