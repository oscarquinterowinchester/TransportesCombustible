package com.appchoferes.nomina.shared.config;

import static org.junit.jupiter.api.Assertions.*;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class LorasdbTest {

    @InjectMocks
    private lorasdb lorasdb;

    @Test
    void testCreateUserDataSource() throws Exception {
        // Aquí puedes evitar el uso de "env" si no es necesario
        DataSource dataSource = lorasdb.createUserDataSource(
                "org.h2.Driver", "jdbc:h2:mem:testdb", "sa", "password");

        assertNotNull(dataSource);
    }
}
