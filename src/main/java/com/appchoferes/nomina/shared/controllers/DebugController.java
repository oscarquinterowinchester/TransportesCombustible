package com.appchoferes.nomina.shared.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appchoferes.nomina.shared.context.UserContextHolder;

@RestController
public class DebugController {

    @GetMapping("/current-db")
    public String getCurrentDb() {
        String dbName = UserContextHolder.getDatabaseName();
        return dbName == null ? "No hay base de datos asignada actualmente" : dbName;
    }
}

