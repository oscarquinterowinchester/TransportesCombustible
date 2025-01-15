package com.appchoferes.nomina.controllers.durandb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DebugDbController {

    @Autowired
    @Qualifier("durandbJdbcTemplate")
    private JdbcTemplate durandbJdbcTemplate;

    @GetMapping("/db-check")
    public String checkCurrentDatabase() {
        String currentDatabase = durandbJdbcTemplate.queryForObject("SELECT DATABASE()", String.class);
        return "Conectado a la base de datos: " + currentDatabase;
    }
}
