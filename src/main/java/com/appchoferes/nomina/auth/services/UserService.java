package com.appchoferes.nomina.auth.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.appchoferes.nomina.shared.config.DynamicRoutingDataSource;
import com.appchoferes.nomina.shared.config.lorasdb;
import com.appchoferes.nomina.shared.context.UserContext;
import com.appchoferes.nomina.shared.context.UserContextHolder;

import java.util.Map;

import javax.sql.DataSource;

@Service
public class UserService {
    @Autowired
    private JdbcTemplate jdbcTemplate; // apunta a la BD por defecto (transportesintdb)

    @Autowired
    private DynamicRoutingDataSource dynamicRoutingDataSource;

    @Autowired
    private lorasdb lorasdbConfig;

    @Autowired
    private Environment env;

    public boolean authenticateUser(String loginUsuario, String passwordUsuario) {
        String sql = "SELECT nombreUsuario,apellidoPaterno,empresaID FROM usuarioslogin_tbl WHERE loginUsuario = ? AND CAST(AES_DECRYPT(passwordUsuario, 'integranets01') AS CHAR(100)) = ?";
        System.out.println("Primera consulta: "+sql);
        Map<String, Object> result;
        try {
            System.out.println("Ejecutando primera query");
            result = jdbcTemplate.queryForMap(sql, loginUsuario, passwordUsuario);
        } catch (Exception e) {
            System.out.println("Error primera query: ");
            return false; // No se encontró el usuario
        }

        if (result == null || result.isEmpty()) {
            return false;
        }

        String sqlempresa = "SELECT nombre_db,usuario_db,direccion_db, CAST(AES_DECRYPT(password_db,'integranets01') as CHAR(100)) as password_db FROM clientesempresas_tbl WHERE ID = ? ";
        Map<String, Object> resultempresa;
        try {
            resultempresa = jdbcTemplate.queryForMap(sqlempresa, (Integer) result.get("empresaID"));
        } catch (Exception e) {
            return false; // No se encontró datos de la empresa
        }
        if (resultempresa == null || resultempresa.isEmpty()) {
            return false;
        }

        String dbName = (String) resultempresa.get("nombre_db");
        String dbUser = (String) resultempresa.get("usuario_db");
        String dbPass = (String) resultempresa.get("password_db");
        String dbHost = (String) resultempresa.get("direccion_db");
        String dbEmpresa = (String) result.get("empresaID").toString();
        String dbNombreUsuario = (String) result.get("nombreUsuario");
        String dbApellidoPaterno = (String) result.get("apellidoPaterno");

        String driverClassName = env.getProperty("spring.datasource.driver-class-name");
        // Construye la URL de la BD del usuario
        String dbUrl = "jdbc:mysql://"+dbHost+"/" + dbName + "?serverTimezone=UTC";

        try {
            DataSource userDS = lorasdbConfig.createUserDataSource(driverClassName, dbUrl, dbUser, dbPass);
            dynamicRoutingDataSource.addDataSource(dbName, userDS);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        UserContextHolder.setUserContext(new UserContext(dbName, dbUser, dbPass,dbEmpresa, dbNombreUsuario, dbApellidoPaterno));
        return true;
    }
}

