package com.appchoferes.nomina.repositories.durandb;

import org.hibernate.boot.model.naming.PhysicalNamingStrategy;
import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;
import org.springframework.stereotype.Component;

@Component
public class CustomPhysicalNamingStrategy implements PhysicalNamingStrategy {

    @Override
    public Identifier toPhysicalColumnName(Identifier name, JdbcEnvironment context) {
        // Devuelve el nombre original de la columna
        return name;
    }

    @Override
    public Identifier toPhysicalCatalogName(Identifier name, JdbcEnvironment jdbcEnvironment) {
        return name;
        // throw new UnsupportedOperationException("Unimplemented method
        // 'toPhysicalCatalogName'");
    }

    @Override
    public Identifier toPhysicalSchemaName(Identifier name, JdbcEnvironment jdbcEnvironment) {
        return name;
        // throw new UnsupportedOperationException("Unimplemented method
        // 'toPhysicalSchemaName'");
    }

    @Override
    public Identifier toPhysicalTableName(Identifier name, JdbcEnvironment jdbcEnvironment) {
        return name;
        // throw new UnsupportedOperationException("Unimplemented method
        // 'toPhysicalTableName'");
    }

    @Override
    public Identifier toPhysicalSequenceName(Identifier name, JdbcEnvironment jdbcEnvironment) {
        return name;
        // throw new UnsupportedOperationException("Unimplemented method
        // 'toPhysicalSequenceName'");
    }

    // Los demás métodos se pueden dejar vacíos o con la implementación por defecto
}
