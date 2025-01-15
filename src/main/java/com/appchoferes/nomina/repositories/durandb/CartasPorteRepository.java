package com.appchoferes.nomina.repositories.durandb;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.appchoferes.nomina.models.durandb.CartasPorteModel;


@Repository
public interface CartasPorteRepository extends JpaRepository<CartasPorteModel, Integer> {
    ArrayList<CartasPorteModel> findByStatus(int Status);

    @Query(value="SELECT * FROM cartasporte_tbl ORDER BY FechaRegistro DESC LIMIT 1", nativeQuery = true)
    CartasPorteModel findFirstByOrderByFechaRegistroDesc();

    @Query(value="SELECT * FROM cartasporte_tbl c WHERE c.FolioFiscalcp = :folio", nativeQuery = true)
    CartasPorteModel findByUUID(String folio);

    @Query(value="SELECT * FROM cartasporte_tbl c WHERE c.NoCartaPorte = :NoCartaPorte", nativeQuery = true)
    CartasPorteModel findByNoCartasPorteModel(String NoCartaPorte);

    @Query(value="SELECT * FROM cartasporte_tbl c WHERE c.itinerarioID = :itinerarioID AND c.Status = :status", nativeQuery = true)
    Optional<CartasPorteModel> obtenerCartaPorteByItinerarioAndStatus(Integer itinerarioID, Integer status);

    CartasPorteModel findFirstByOrderByCartaPorteIDDesc();

    CartasPorteModel findFirstByGeneracionCartaPorteOrderByFechaRegistroDesc(int generacionCartaPorte);

    @Query(value="SELECT * FROM cartasporte_tbl WHERE Status = 1 ORDER BY CartaPorteID DESC LIMIT 100", nativeQuery = true)
    ArrayList<CartasPorteModel> getCartasPorte();

    @Query(value = "SELECT * FROM cartasporte_tbl cp WHERE cp.CartaPorteID = :id", nativeQuery = true)
    CartasPorteModel findByCartaPorteID(Integer id);
}
