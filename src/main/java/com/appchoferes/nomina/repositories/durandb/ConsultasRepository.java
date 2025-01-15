package com.appchoferes.nomina.repositories.durandb;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.appchoferes.nomina.models.durandb.ConsultasModel;

@Repository
public interface ConsultasRepository extends CrudRepository<ConsultasModel, Integer> {

    @Query(value = "SELECT CASE WHEN em.RFC = (SELECT RFC FROM clientes_tbl cc WHERE cc.ClienteID = :clienteID ) THEN true ELSE FALSE END as dato, '' as ConceptoSAT, '' as UnidadSAT, '' as DescripcionCompleta FROM empresas_tbl em WHERE em.EmpresaID = :empresaID ", nativeQuery = true)
    Optional<ConsultasModel> findisTraslado(Integer empresaID,Integer clienteID);

    @Query(value = "SELECT '' as dato, (SELECT getFacDescripcionFull('0', true, WContID1, WContID2)) as DescripcionCompleta,\n" + //
                "(SELECT Codigo FROM conceptossatr_tbl WHERE ConceptoID = :conceptoSATID ) as ConceptoSAT,\n" + //
                "(SELECT Unidad FROM conceptossatr_tbl WHERE ConceptoID = :conceptoSATID) as UnidadSAT\n" + //
                " FROM iticartasporte_tbl itc WHERE itc.ItinerarioID = :itinerarioID ORDER BY ICartaID DESC LIMIT 1; ", nativeQuery = true)
    Optional<ConsultasModel> getdataRutas(Integer conceptoSATID,Integer itinerarioID);
}
