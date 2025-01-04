package com.appchoferes.nomina.shared.config;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.sql.DataSource;

import com.appchoferes.nomina.config.DatabaseContextHolder;
import com.appchoferes.nomina.shared.context.UserContextHolder;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class DynamicRoutingDataSource extends AbastractRoutingDataSource {

    private final Map<Object, Object> dataSourceMap = new ConcurrentHashMap<>();

    public void addDataSource(String dbName, String ds) {
        dataSourceMap.put(dbName, ds);
        super.setTargetDataSources(dataSourceMap);
        super.afterPropertiesSet();
    }

    public void removeDataSource(String dbName) {
        dataSourceMap.remove(dbName);
        super.setTargetDataSources(dataSourceMap);
        super.afterPropertiesSet();
    }

    public boolean hasDataSource(String dbName) {
        return dataSourceMap.containsKey(dbName);
    }

    public Map<Object, Object> getAvailableDataSources() {
        return new ConcurrentHashMap<>(dataSourceMap);
    }

    protected Object determineCurrentLookupKey() {
        String dbName = UserContextHolder.getDatabaseName();
        if (dbName == null) {
            throw new IllegalStateException("No se encontro un contexto de base de datos valido");
        }
        return dbName;
    }

}
