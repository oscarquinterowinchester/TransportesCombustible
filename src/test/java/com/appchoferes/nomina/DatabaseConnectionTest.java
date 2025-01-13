package com.appchoferes.nomina;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DatabaseConnectionTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void testDatabaseConnection() {
        String sql = "SELECT 1";
        Integer result = jdbcTemplate.queryForObject(sql, Integer.class);
        assertNotNull(result, "La conexión a la base de datos falló");
        assertEquals(1, result, "El valor devuelto por la base de datos no es 1");
    }
}
