package com.appchoferes.nomina.modules.itinerario.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.appchoferes.nomina.modules.itinerario.models.ContenedorEntity;

@Repository
public interface ContenedorRepository extends CrudRepository<ContenedorEntity,Long>{

    @Query(value = "CALL DM_getContenedorInfoIti(:itinerarioId);", nativeQuery = true)
    public List<ContenedorEntity> getContenedores(String itinerarioId);

}



