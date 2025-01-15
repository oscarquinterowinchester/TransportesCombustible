package com.appchoferes.nomina.repositories.durandb;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.appchoferes.nomina.models.durandb.CamionModel;
import com.appchoferes.nomina.models.durandb.ItiCartasPorteModel;

@Repository
public interface ItiCartasPorteRepository extends JpaRepository<ItiCartasPorteModel, Integer> {
    ArrayList<ItiCartasPorteModel> findByStatus(int Status);

    @Query(value = "SELECT * FROM iticartasporte_tbl itc WHERE itc.cartaPorteID = :id", nativeQuery = true)
    ItiCartasPorteModel findByCartaPorteID(Integer id);



    @Query("SELECT camion.anio FROM ItiCartasPorteModel itc " +
            "LEFT JOIN itc.itinerario it " +
            "LEFT JOIN it.camion camion " +
            "WHERE itc.ItinerarioID = :ItinerarioID")
    String findAnioByItinerarioID(@Param("ItinerarioID") Integer ItinerarioID);

    @Query("SELECT itc.itinerario.camion FROM ItiCartasPorteModel itc WHERE itc.itinerario.ItinerarioID = :ItinerarioID")
    CamionModel findCamionByItinerarioID(@Param("ItinerarioID") Integer ItinerarioID);

    @Query(value = "SELECT * FROM iticartasporte_tbl itc WHERE itc.ItinerarioID = :id ORDER BY ICartaID DESC LIMIT 1", nativeQuery = true)
    Optional<ItiCartasPorteModel> findByItinerarioID(Integer id);

    @Query(value = "SELECT * FROM iticartasporte_tbl itc WHERE itc.cartaPorteID = :id", nativeQuery = true)
    Optional<ItiCartasPorteModel> findByCartaPorteIDAndStatus(Integer id);

    @Query(value = "SELECT * FROM iticartasporte_tbl itc WHERE itc.itinerarioID = :id AND itc.NoCartaPorte != :cartaporte ORDER BY ICartaID DESC LIMIT 1", nativeQuery = true)
    Optional<ItiCartasPorteModel> findItiCartaPorteToCancel(Integer id, String cartaporte);

}
