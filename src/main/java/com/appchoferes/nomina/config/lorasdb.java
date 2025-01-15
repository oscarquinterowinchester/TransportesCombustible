package com.appchoferes.nomina.config;

import java.sql.Driver;
import java.util.HashMap;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

public class lorasdb {

    @Bean(name = "lorasdbDataSource")
    public DynamicRoutingDataSource lorasdbDataSource(Environment env) throws Exception {
        DynamicRoutingDataSource dynamicDataSource = new DynamicRoutingDataSource();

        SimpleDriverDataSource defaultDataSource = new SimpleDriverDataSource();
        defaultDataSource.setDriverClass(
                (Class<? extends Driver>) Class.forName(env.getProperty("spring.datasource.driver-class-name")));
        defaultDataSource.setUrl(env.getProperty("spring.datasource.url"));
        defaultDataSource.setUsername(env.getProperty("spring.datasource.username"));
        defaultDataSource.setPassword(env.getProperty("spring.datasource.password"));

        HashMap<Object, Object> emptyMap = new HashMap<>();

        dynamicDataSource.setTargetDataSources(emptyMap);

        dynamicDataSource.setDefaultTargetDataSource(defaultDataSource);

        dynamicDataSource.afterPropertiesSet();

        return dynamicDataSource;
    }

    @Bean(name = "lorasdbJdbcTemplate")
    public JdbcTemplate lorasdbJdbcTemplate(@Qualifier("lorasdbDataSource") DataSource lorasdbDataSource) {
        return new JdbcTemplate(lorasdbDataSource);
    }

    public DataSource createUserDataSource(String driverClassName, String url, String username, String password)
            throws Exception {
        try {
            SimpleDriverDataSource userDataSource = new SimpleDriverDataSource();
            userDataSource.setDriverClass((Class<? extends Driver>) Class.forName(driverClassName));
            userDataSource.setUrl(url);
            userDataSource.setUsername(username);
            userDataSource.setUsername(password);
            return userDataSource;

        } catch (ClassNotFoundException e) {
            throw new Exception("El driver de la base de datos no se pudo cargar: " + driverClassName, e);

        } catch (Exception e) {

            throw new Exception("Error al crear el DataSource dinamico", e);
        }

    }

}
