package com.appchoferes.nomina.shared.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;

public class jdbcTemplateConfig {

    /*
     * DataSource para la base de datos de transportesintdb
     * La base de datos se utiliza para validar al usuario
     * Las propiedades se obtendran de application.properties con el prefijo de
     * sping.datasource.
     */

    @Bean(name = "transportesintdbDataSource")
    @Primary
    public DataSource transportesintdbDataSource(Environment env) {
        return DataSourceBuilder.create()
                .driverClassName(env.getProperty("spring.datasource.driver-class-name"))
                .url(env.getProperty("spring.datasource.url"))
                .username(env.getProperty("spring.datasource.username"))
                .password(env.getProperty("spring.datasource.password"))
                .build();
    }

    /*
     * JdbcTemplate usa la base de datos transportesintdb.
     * Se encarga de inyectar en UsuarioService para validar credenciales.
     */
    @Bean(name = "transportesintdbTJdbcTemplate")
    @Primary
    public JdbcTemplate transportesintdbTJdbcTemplate(@Qualifier("transportesintdbTJdbcTemplate") DataSource ds) {
        return new JdbcTemplate(ds);
    }

}
