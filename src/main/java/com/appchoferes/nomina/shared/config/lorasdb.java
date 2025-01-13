package com.appchoferes.nomina.shared.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import java.sql.Driver;
import java.util.HashMap;

@Configuration
public class lorasdb {

    @Bean(name = "lorasdbDataSource")
    public DynamicRoutingDataSource lorasdbDataSource(Environment env) throws Exception {
        DynamicRoutingDataSource dynamicDataSource = new DynamicRoutingDataSource();

        SimpleDriverDataSource defaultDataSource = new SimpleDriverDataSource();
        defaultDataSource.setDriverClass((Class<? extends Driver>) Class.forName(env.getProperty("spring.datasource.driver-class-name")));
        defaultDataSource.setUrl(env.getProperty("spring.datasource.url"));
        defaultDataSource.setUsername(env.getProperty("spring.datasource.username"));
        defaultDataSource.setPassword(env.getProperty("spring.datasource.password"));

        // Definir al menos un mapa vacío de targetDataSources antes de afterPropertiesSet
        HashMap<Object, Object> emptyMap = new HashMap<>();
        dynamicDataSource.setTargetDataSources(emptyMap);
        
        // Establecemos el DataSource por defecto
        dynamicDataSource.setDefaultTargetDataSource(defaultDataSource);

        // Después de setear defaultTargetDataSource y targetDataSources, llamamos a afterPropertiesSet
        dynamicDataSource.afterPropertiesSet();

        return dynamicDataSource;
    }

    @Bean(name = "lorasdbJdbcTemplate")
    public JdbcTemplate lorasdbJdbcTemplate(@Qualifier("lorasdbDataSource") DataSource lorasdbDataSource) {
        return new JdbcTemplate(lorasdbDataSource); 
        
    }
    public DataSource createUserDataSource(String driverClassName, String url, String username, String password) throws Exception {
        try {
            SimpleDriverDataSource userDataSource = new SimpleDriverDataSource();
            userDataSource.setDriverClass((Class<? extends Driver>) Class.forName(driverClassName));
            userDataSource.setUrl(url);
            userDataSource.setUsername(username);
            userDataSource.setPassword(password);
            return userDataSource;
        } catch (ClassNotFoundException e) {
            throw new Exception("El driver de la base de datos no se pudo cargar: " + driverClassName, e);
        } catch (Exception e) {
            throw new Exception("Error al crear el DataSource dinámico", e);
        }
    }
}

