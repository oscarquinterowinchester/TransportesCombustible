package com.appchoferes.nomina.repositories.lorasdb;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.appchoferes.nomina.models.lorasdb.Itinerario;

import java.util.List;

@Repository
public interface ItinerarioRepo extends JpaRepository<Itinerario, Integer> {
    @Query(value = "SELECT ItinerarioID FROM itinerarios_tbl WHERE ItinerarioID IN (SELECT ico.ItinerarioID FROM icont_tbl AS ico WHERE ico.Status = true AND (ico.ncontenedor = :contenedor OR ico.Caja = :contenedor)) AND Status = 1", nativeQuery = true)
    List<Itinerario> findByContenedor(@Param("contenedor") String contenedor);


    @Query(value = "SELECT iti.ItinerarioID, IF(ico.ncontenedor IS NULL OR ico.ncontenedor = '', ico.Caja, ico.ncontenedor) AS Contenedor, " +
    "wo.ClienteFK, ru.origen, getSelloIti(iti.itinerarioId) AS Sello, " +
    "(SELECT Nombre FROM estados_tbl WHERE EstadoID = (SELECT Placas FROM camiones_tbl WHERE camiones_tbl.CamionID = iti.CamionID)) AS estadomex, " +
    "iti.RutaID, (SELECT RazonSocial FROM empresas_tbl WHERE EmpresaID = 1) AS Carrier, wo.Tamano, " +
    "(CASE WHEN PaisID = 1 THEN 'México' WHEN PaisID = 2 THEN 'USA' ELSE 'N/A' END) AS pais, " +
    "IF(EstadoCarga = 0, 'Vacio', 'Cargado') AS carga, " +
    "(SELECT Nombre FROM estados_tbl WHERE EstadoID = (SELECT PlacasUSA FROM camiones_tbl WHERE camiones_tbl.CamionID = iti.CamionID)) AS estadousa, " +
    "(SELECT Nombre FROM rutas_tbl WHERE rutas_tbl.RutaID = iti.RutaID) AS ruta, " +
    "(SELECT NoEconomico FROM camiones_tbl WHERE camiones_tbl.CamionID = iti.CamionID) AS camion, " +
    "(SELECT CONCAT(placas, ' ', placasusa) FROM cajas_tbl WHERE cajas_tbl.CajaID = wo.CajaID) AS PlacasChasis, " +
    "(SELECT CONCAT(placas, ' ', placasusa) FROM camiones_tbl WHERE camiones_tbl.CamionID = iti.CamionID) AS PlacasUnidad, " +
    "(SELECT Nombre FROM choferes_tbl WHERE ChoferID = iti.ChoferID) AS NombreChofer, " +
    "iti.ChoferID AS ChoferID, wo.ClienteFK AS ClienteID, " +
    "(SELECT NComercial FROM clientes_tbl WHERE clienteID = wo.ClienteFK) AS cliente, " +
    ":inventarioID AS InventarioID " +
    "FROM itinerarios_tbl iti " +
    "LEFT JOIN icont_tbl ico ON ico.ItinerarioID = iti.ItinerarioID " +
    "LEFT JOIN workcontenedores_tbl wo ON wo.WContenedorID = ico.WContID " +
    "LEFT JOIN rutas_tbl ru ON ru.RutaID = iti.RutaID " +
    "WHERE iti.ItinerarioID = :itinerarioID", nativeQuery = true)
    
List<Object[]> findContenedorByItinerarioID(@Param("itinerarioID") int itinerarioID, @Param("inventarioID") int inventarioID);
}