package com.appchoferes.nomina.repositories.lorasdb;

import java.time.LocalDateTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.appchoferes.nomina.models.lorasdb.InventarioExternoInspeccion;

@Repository
public interface InventarioExternoInspeccionRepository extends JpaRepository<InventarioExternoInspeccion, Integer> {
   
    @Modifying
    @Query(value =  "UPDATE inventarioexternoinspecciones_tbl i SET " +
            "i.InventarioSalidaID = :inventarioSalidaID, " +
            "i.Salida = :salida, " +
            "i.FechaSalida = :fechaSalida, " +
            "i.comentariosalida = :comentariosalida, " +
            "i.fotosalida = :fotosalida " +
            "WHERE i.id = :id", nativeQuery = true)
    void actualizarInspeccionSalida(
            @Param("id") Integer id,
            @Param("inventarioSalidaID") Integer inventarioSalidaID,
            @Param("salida") Integer salida,
            @Param("fechaSalida") LocalDateTime fechaSalida,
            @Param("comentariosalida") String comentariosalida,
            @Param("fotosalida") String fotosalida);
}