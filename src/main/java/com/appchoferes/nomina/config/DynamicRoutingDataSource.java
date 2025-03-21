package com.appchoferes.nomina.config;

import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;
import javax.sql.DataSource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import com.appchoferes.nomina.services.lorasdb.UserContextHolder;

public class DynamicRoutingDataSource extends AbstractRoutingDataSource {

    private final Map<Object, Object> dataSourceMap = new ConcurrentHashMap<>();

    public void addDataSource(String dbName, DataSource ds) {
        dataSourceMap.put(dbName, ds);
        super.setTargetDataSources(dataSourceMap);
        super.afterPropertiesSet(); // Refresca la configuración del AbstractRoutingDataSource
    }

    public void removeDataSource(String dbName) {
        dataSourceMap.remove(dbName);
        super.setTargetDataSources(dataSourceMap);
        super.afterPropertiesSet(); // Refresca la configuración
    }

    public boolean hasDataSource(String dbName) {
        return dataSourceMap.containsKey(dbName);
    }

    public Map<Object, Object> getAvailableDataSources() {
        return new ConcurrentHashMap<>(dataSourceMap);
    }

    @Override
    protected Object determineCurrentLookupKey() {
        if (UserContextHolder.getUserContext() == null ||
                UserContextHolder.getUserContext().getDatabaseName() == null) {
            throw new IllegalStateException("No se encontró un contexto de base de datos válido.");
        }
        return UserContextHolder.getUserContext().getDatabaseName();
    }
}
