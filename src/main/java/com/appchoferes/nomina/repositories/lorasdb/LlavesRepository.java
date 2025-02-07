package com.appchoferes.nomina.repositories.lorasdb;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.appchoferes.nomina.models.lorasdb.Llaves;
import com.appchoferes.nomina.models.lorasdb.dtos.LlaveDTO;

import jakarta.persistence.Tuple;

import java.util.List;

@Repository
public interface LlavesRepository extends JpaRepository<Llaves, Long> {

    // Query con la fecha actualizada para el servidor
    /*
     * @Query(value = "SELECT IF(tipo = '1', 'Entrega', 'Recibe') AS tipo, " +
     * "(SELECT Nombre FROM choferes_tbl WHERE ChoferID = l.ChoferID) AS chofer, " +
     * "(SELECT NoEconomico FROM camiones_tbl WHERE CamionID = l.CamionID) AS camion "
     * +
     * "FROM llaves_tbl AS l WHERE DATE(fecha) = date(now())",
     * nativeQuery = true)
     */
    @Query(value = "SELECT IF(tipo = '1', 'Entrega', 'Recibe') AS tipo, " +
            "(SELECT Nombre FROM choferes_tbl WHERE ChoferID = l.ChoferID) AS chofer, " +
            "(SELECT NoEconomico FROM camiones_tbl WHERE CamionID = l.CamionID) AS camion " +
            "FROM llaves_tbl AS l", nativeQuery = true)
    List<Tuple> findLlaveTuples();
}
