package com.appchoferes.nomina.modules.itinerario.repositories;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.appchoferes.nomina.modules.itinerario.models.DriverMoveEntity;


@Repository
public interface DriveMoveRepository extends CrudRepository<DriverMoveEntity,Long>{

    @Query(value = "CALL DM_getItinerarioChofer(:choferId);", nativeQuery = true)
    public List<DriverMoveEntity> getDriveMoveByChofer(String choferId);

    @Query(value = "CALL DM_setItinerarioAsVisto(:itinerarioId);", nativeQuery = true)
    public int setItinerarioAsVisto(String itinerarioId);
}
