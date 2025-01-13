package com.appchoferes.nomina.auth.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.appchoferes.nomina.auth.models.EmpresaModel;
import com.appchoferes.nomina.auth.models.UsuarioModel;
import com.appchoferes.nomina.auth.services.EmpresaService;
import com.appchoferes.nomina.auth.services.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    EmpresaService empresaService;

    @GetMapping()
    public ArrayList<UsuarioModel> obtenerUsuarios() {
        return usuarioService.obtenerUsuarios();
    }

    @GetMapping(value = "/buscar", produces = "application/json")
    public ResponseEntity<?> buscarUsuarios(@RequestParam String usuario, @RequestParam String password) {
        
        List<UsuarioModel> usuarios = usuarioService.findByUsuarioAndPassword(usuario, password);

        EmpresaModel empresa = empresaService.seleccionarEmpresa(1);
        System.out.println(empresa);

        Map<String, Object> response = new HashMap<>();

        response.put("usuario", usuarios.isEmpty() ? new UsuarioModel() : usuarios.get(0));
        response.put("empresa", empresa);
        response.put("success", true);

        return ResponseEntity.ok(response);
    } 

    @PostMapping(
        value = "/login",
        consumes = "application/json;charset=UTF-8",
        produces = "application/json"
    )
    public ResponseEntity<?> login(@RequestBody String requestData) {
        try {
            Map<String, Object> response = new HashMap<>();
            response.put("success", true);
            return ResponseEntity.ok(response);

        } catch(Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

}
