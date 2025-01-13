package com.appchoferes.nomina.auth.services;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootTest
public class UserServiceTest {

    @MockBean
    JdbcTemplate jTemplate;

    @Autowired
    UserService userService;

    public void userAuthentication_succes() {
        String user = "user";
        String pass = "pass";

        Map<String, Object> result = new HashMap<>();
        result.put("nombreUsuario", "bad");
        result.put("apellidoPaterno", "bunny");
        result.put("empresaID", 1);

        when(jTemplate.queryForMap(
                "SELECT nombreUsuario, apellidoPaterno, empresaID FROM usuarioslogin_tbl WHERE loginUsuario = ? AND CAST(AES_DECRYPT(passwordUsuario, 'integranets01') AS CHAR(100)) = ?",
                user, pass))
                .thenReturn(result);

        boolean autenticacion = userService.authenticateUser(user, pass);

        assertTrue(autenticacion);
    }

}
