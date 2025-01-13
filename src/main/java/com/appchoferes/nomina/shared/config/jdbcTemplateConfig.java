package com.appchoferes.nomina.shared.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class jdbcTemplateConfig {

   /**
     * DataSource para la base de datos transportesintdb.
     * Esta base de datos se utiliza para validar al usuario.
     * Las propiedades se obtendrán de application.properties con el prefijo spring.datasource.
     */
    @Bean(name = "transportesintdbDataSource")
    @Primary
    public DataSource transportesintdbDataSource(Environment env) {
        return DataSourceBuilder.create()
                .driverClassName(env.getProperty("spring.datasource.driver-class-name"))
                .url(env.getProperty("spring.datasource.url")) // Ej: jdbc:mysql://localhost:3306/transportesintdb
                .username(env.getProperty("spring.datasource.username"))
                .password(env.getProperty("spring.datasource.password"))
                .build();
    }

    /**
     * JdbcTemplate que usa la base de datos transportesintdb.
     * Este será el JdbcTemplate que se inyectará en UserService para validar credenciales.
     */
    @Bean(name = "transportesintdbJdbcTemplate")
    @Primary
    public JdbcTemplate transportesintdbJdbcTemplate(@Qualifier("transportesintdbDataSource") DataSource ds) {
        return new JdbcTemplate(ds);
    }
}

