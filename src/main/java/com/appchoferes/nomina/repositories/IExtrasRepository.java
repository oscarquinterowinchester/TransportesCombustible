package com.appchoferes.nomina.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.appchoferes.nomina.dtos.ExtrasDTOOld;

public interface IExtrasRepository extends JpaRepository<ExtrasDTOOld, Long> {
    @Query(value = "SELECT Descripcion as description, CargoID as id, Moneda AS currency, Cantidad as quantity, IF(Movimiento = 0,'Descuento', 'Bono') as type, Importe as amount, (SELECT Nombre from monedas_tbl where monedas_tbl.Moneda = cajachica_tbl.Moneda) as divisa, statusNomina as status from  cajachica_tbl  where Status = true and ItinerarioID = :ItinerarioID", nativeQuery = true)
    public List<ExtrasDTOOld> getExtras(Long ItinerarioID);
}
