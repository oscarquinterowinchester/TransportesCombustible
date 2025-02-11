package com.appchoferes.nomina.services.lorasdb;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appchoferes.nomina.models.lorasdb.VisitorGafete;
import com.appchoferes.nomina.models.lorasdb.dtos.BusquedaVisitanteDTO;
import com.appchoferes.nomina.models.lorasdb.dtos.EmpleadoDTO;
import com.appchoferes.nomina.models.lorasdb.dtos.EmpresaDTO;
import com.appchoferes.nomina.models.lorasdb.dtos.PuntosCTPADSalidaDTO;
import com.appchoferes.nomina.models.lorasdb.dtos.TipoVisitante2DTO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

@Service
public class RawQueryService {

    @Autowired
    private EntityManager entityManager;

    /**
     * Obtiene los tipos de visitantes excluyendo ciertos IDs
     */
    public List<TipoVisitante2DTO> getTipoVisitantes2(List<Integer> ids) {
        // verifica si la lista de ids viene vacion, de ser asi agrega 0 para realizar
        // la query
        if (ids == null || ids.isEmpty()) {
            ids = List.of(0);
        }

        String sql = """
                    SELECT v.id, v.nombre,
                        (SELECT COUNT(g.id) FROM visitor_gafetes g WHERE g.tipo = v.id AND g.visitante IS NULL) AS disponibles,
                        (SELECT COUNT(g.id) FROM visitor_gafetes g WHERE g.tipo = v.id AND g.visitante IS NOT NULL) AS ocupados
                    FROM visitor_tipo_visitantes v
                    WHERE v.id NOT IN (?1) ORDER BY v.nombre
                """;

        Query query = entityManager.createNativeQuery(sql);
        query.setParameter(1, ids);
        List<Object[]> resultado = query.getResultList();

        return resultado.stream().map(obj -> new TipoVisitante2DTO(
                ((Number) obj[0]).intValue(), // ID
                (String) obj[1], // Nombre
                ((Number) obj[2]).intValue(), // Disponibles
                ((Number) obj[3]).intValue() // Ocupados
        )).collect(Collectors.toList());
    }

    /**
     * Buscar visitantes con filtro opcional por nombre
     */
    public List<BusquedaVisitanteDTO> buscarVisitantes(String word) {
        String sql = """
                    SELECT v.id, v.nombre, v.empresa AS empresaID, v.tipo AS tipo_visitante, 0 AS visto,
                        (SELECT e.nombre FROM visitor_empresas e WHERE e.id = v.empresa) AS empresa,
                        (SELECT t.nombre FROM visitor_tipo_visitantes t WHERE t.id = v.tipo) AS tipo,
                        v.fecha AS last, v.id AS exist,
                        IF(v.foto IS NOT NULL, v.foto, 'img/nopic.png') AS foto,
                        'img/noid.png' AS identificacion
                    FROM visitor_visitantes v
                    WHERE v.id > 0
                    AND v.id NOT IN (SELECT r.visitanteID FROM visitor_registros r WHERE r.salida IS NULL)
                    AND (:word IS NULL OR v.nombre LIKE :word)
                    ORDER BY v.nombre
                """;

        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("word", word);
        List<Object[]> resultado = query.getResultList();

        return resultado.stream().map(obj -> new BusquedaVisitanteDTO(
                ((Number) obj[0]).longValue(), // id
                (String) obj[1], // nombre
                obj[2] != null ? ((Number) obj[2]).longValue() : null, // empresaID
                obj[3] != null ? ((Number) obj[3]).longValue() : null, // tipoVisitante
                ((Number) obj[4]).intValue(), // visto
                (String) obj[5], // empresa
                (String) obj[6], // tipo
                ((Timestamp) obj[7]).toLocalDateTime(), // last
                ((Number) obj[8]).longValue(), // exist
                (String) obj[9], // foto
                (String) obj[10] // identificacion
        )).collect(Collectors.toList());
    }

    public List<VisitorGafete> getGafetesDisponibles(Integer tipo) {
        String tipoQuery = (tipo != null) ? "AND tipo = :tipo" : "";

        String sql = """
                SELECT * FROM visitor_gafetes
                WHERE visitante IS NULL
                """ + tipoQuery;

        Query query = entityManager.createNativeQuery(sql, VisitorGafete.class); // Mapea a la entidad directamente

        // Si se pasa el tipo, establecer el parametro en la consulta
        if (tipo != null) {
            query.setParameter("tipo", tipo);
        }

        return query.getResultList(); // Devuelve una lista de objetos VisitorGafete
    }

    public List<EmpleadoDTO> getEmpleados() {
        String sql = """
                    SELECT ChoferID as id, Nombre as nombre,
                           IF(Telefono = 'NONE', 0, Telefono) AS telefono,
                           (SELECT Nombre FROM puestos_tbl WHERE PuestoID = choferes_tbl.Puesto) AS area,
                           'No definido' as puesto
                    FROM choferes_tbl
                    WHERE Status = true
                    ORDER BY nombre
                """;

        Query query = entityManager.createNativeQuery(sql);
        List<Object[]> resultList = query.getResultList();

        // Mapeo de los resultados a EmpleadoDTO
        return resultList.stream().map(row -> new EmpleadoDTO(
                ((Number) row[0]).intValue(), // id
                (String) row[1], // nombre
                (String) row[2], // telefono
                (String) row[3], // area
                (String) row[4] // puesto
        )).collect(Collectors.toList());
    }

    public List<EmpresaDTO> getEmpresas() {
        String sql = """
                    SELECT e.id, e.nombre,
                           (SELECT COUNT(v.id) FROM visitor_visitantes v WHERE v.empresa = e.id) AS count
                    FROM visitor_empresas e
                    WHERE e.nombre <> ''
                    ORDER BY e.nombre
                """;

        Query query = entityManager.createNativeQuery(sql);
        List<Object[]> results = query.getResultList();

        return results.stream().map(obj -> new EmpresaDTO(
                ((Number) obj[0]).longValue(),
                (String) obj[1],
                ((Number) obj[2]).longValue())).collect(Collectors.toList());
    }

    public List<PuntosCTPADSalidaDTO> getPuntosCTPADSalida(Integer id) {

        String sql = """
                    SELECT i.InventarioID, i.ListadoID, 0 as Salida,
                           (SELECT Nombre FROM listadoinspecciones_tbl WHERE ListadoID = i.ListadoID) as Nombre
                    FROM inventarioexternoinspecciones_tbl i
                    WHERE i.InventarioID = :id
                """;

        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("id", id);
        List<Object[]> result = query.getResultList();

        if (result.isEmpty()) {
            String insertSql = """
                        INSERT INTO inventarioexternoinspecciones_tbl (ListadoID, InventarioID, Entrada)
                        SELECT ListadoID, :id, 0 FROM listadoinspecciones_tbl WHERE Status = 1
                    """;

            entityManager.createNativeQuery(insertSql).setParameter("id", id).executeUpdate();

            query = entityManager.createNativeQuery(sql);
            query.setParameter("id", id);
            result = query.getResultList();
        }

        return result.stream()
                    .map(obj -> new PuntosCTPADSalidaDTO(
                            ((Number) obj[0]).intValue(),
                            ((Number) obj[1]).intValue(),
                            0,
                            (String) obj[2]))
                    .collect(Collectors.toList());
    }

}
