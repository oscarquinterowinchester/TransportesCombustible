package com.appchoferes.nomina.shared.context;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DebugController {

    @GetMapping("/current-db")
    public String getCurrentDb() {
        String dbName = UserContextHolder.getDatabaseName();
        return dbName == null ? "No hay base de datos asignada actualmente" : dbName;
    }
}

