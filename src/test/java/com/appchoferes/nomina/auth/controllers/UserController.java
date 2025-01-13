package com.appchoferes.nomina.auth.controllers;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Collections;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;

import com.appchoferes.nomina.auth.models.EmpresaModel;
import com.appchoferes.nomina.auth.models.UsuarioModel;
import com.appchoferes.nomina.auth.services.UserService;
import com.appchoferes.nomina.auth.services.UsuarioService;
import com.appchoferes.nomina.shared.context.UserContext;
import com.appchoferes.nomina.shared.context.UserContextHolder;

import io.jsonwebtoken.security.Keys;

@SpringBootTest
public class UserController {

    @MockBean
    UserService userService;

    @MockBean
    UsuarioService usuarioService;

    @MockBean
    AuthController authController;

    @MockBean
    MockMvc mockMvc;

    @Test
    public void login() {

        when(userService.authenticateUser("user", "pass")).thenReturn(true);

        UserContext userContext = new UserContext("db", "userdb", "passdb", "1", "Juan", "Carlos");
        UserContextHolder.setUserContext(userContext);

        UsuarioModel usuarioModel = new UsuarioModel();
        usuarioModel.setUsuarioID(1);
        usuarioModel.setNombre("Juan");
        usuarioModel.setIDUsuarioIntegranet(1);
        when(usuarioService.findByUsuarioAndPassword("user", "pass"))
                .thenReturn(Collections.singletonList(usuarioModel));

        EmpresaModel empresaModel = new EmpresaModel();
        empresaModel.setEmpresaID(1);
        empresaModel.setCP("123");
        empresaModel.setRFC("AODE");
        empresaModel.setNComercial("blablabla");
        empresaModel.setRazonSocial("ninguna");
        empresaModel.setRegimenFiscal("no le entiendo al SAT");

        Key mockKey = Keys.hmacShaKeyFor("yamequieroir".getBytes(StandardCharsets.UTF_8));
        ReflectionTestUtils.setField(authController, "jwtkey", mockKey);

        try {
            mockMvc.perform(get("/auth/login")
                    .param("usuario", "testUser")
                    .param("password", "testPass"))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.accessToken").isNotEmpty())
                    .andExpect(jsonPath("$.usuario.nombre").value("Juan"))
                    .andExpect(jsonPath("$.empresa.nombre").value("Empresa Test"));
        } catch (Exception e) {
        }
    }

}
