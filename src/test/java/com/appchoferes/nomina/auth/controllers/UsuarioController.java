package com.appchoferes.nomina.auth.controllers;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import com.appchoferes.nomina.auth.models.UsuarioModel;
import com.appchoferes.nomina.auth.services.UsuarioService;

@SpringBootTest
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @MockBean
    private MockMvc mockMvc;

    public void obtenerUsuarios() throws Exception{

        ArrayList<UsuarioModel> usuarios = new ArrayList<>();
        UsuarioModel usuario = new UsuarioModel();
        usuario.setIDUsuarioIntegranet(1);
        usuario.setUsuarioID(1);
        usuario.setNombre("yannel");
        usuarios.add(usuario);

        when(usuarioService.obtenerUsuarios()).thenReturn(usuarios);

        mockMvc.perform(get("/usuarios"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].UsuarioID").value(1))
                .andExpect(jsonPath("$[0].nombre").value("yannel"));

    }

}
