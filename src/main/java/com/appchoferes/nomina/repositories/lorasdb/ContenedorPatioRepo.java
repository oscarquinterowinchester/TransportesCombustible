package com.appchoferes.nomina.repositories.lorasdb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.appchoferes.nomina.models.lorasdb.dtos.ContenedorPatios;

import java.util.List;

@Repository
public class ContenedorPatioRepo {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<ContenedorPatios> obtenerContenedores(int patioId, int usuarioId) {
        String query = """
            SELECT *,
            IF(PaisID = 1, 'México', 'Estados unidos') AS pais,
            IF(EstadoCarga = 0, 'Vacio', 'Cargado') AS carga,
            (SELECT NComercial FROM clientes_tbl WHERE clienteID = w.ClienteID LIMIT 1) AS cliente,
            (SELECT Origen FROM rutas_tbl WHERE rutas_tbl.RutaID = w.RutaID LIMIT 1) AS origen,
            (SELECT Nombre FROM estados_tbl WHERE EstadoID = w.EstadoID LIMIT 1) AS estado,
            DATEDIFF(NOW(), FechaEvento) AS dias,
            (SELECT InventarioID FROM inventarioexterno_tbl WHERE AnteriorID = w.InventarioID AND TipoEvento = 2 LIMIT 1) AS flag,
            IFNULL(sello, '') AS sello
            FROM inventarioexterno_tbl AS w
            WHERE PatioID = ?
            AND TipoEvento = 1
            AND UsuarioId = ?
        """;

        return jdbcTemplate.query(query, new Object[]{patioId, usuarioId}, (rs, rowNum) -> {
            ContenedorPatios contenedor = new ContenedorPatios();
            contenedor.setInventarioID(rs.getInt("InventarioID"));
            contenedor.setItinerarioID(rs.getInt("ItinerarioID"));
            contenedor.setAnteriorID(rs.getInt("AnteriorID"));
            contenedor.setWContenedorID(rs.getInt("WContenedorID"));
            contenedor.setContenedor(rs.getString("Contenedor"));
            // ... Mapear el resto de los campos aquí
            contenedor.setEstado(rs.getString("estado"));
            contenedor.setDias(rs.getInt("dias"));
            return contenedor;
        });
    }
}
