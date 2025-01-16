package com.appchoferes.nomina.controllers.lorasdb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.appchoferes.nomina.models.lorasdb.EmpresaModel;
import com.appchoferes.nomina.models.lorasdb.UsuarioModels;
import com.appchoferes.nomina.services.lorasdb.EmpresaService;
import com.appchoferes.nomina.services.lorasdb.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    EmpresaService empresaService;

    @GetMapping()
    public ArrayList<UsuarioModels> obtenerUsuarios() {
        return usuarioService.obtenerUsuarios();
    }

    @GetMapping(value = "/buscar", produces = "application/json")
    public ResponseEntity<?> buscarUsuarios(@RequestParam String usuario, @RequestParam String password) {
        
        // List<UsuarioModels> usuarios = usuarioService.obtenerUsuarios();
        List<UsuarioModels> usuarios = usuarioService.findByUsuarioAndPassword(usuario, password);

        // -- Se trae la empresa con id 2 (pruebas)
        EmpresaModel empresa = empresaService.seleccionarEmpresa(1);

        //System.out.println(empresa);

        Map<String, Object> response = new HashMap<>();
        response.put("usuario", usuarios.isEmpty() ? new UsuarioModels() : usuarios.get(0));
        response.put("empresa", empresa);
        response.put("success", true);

        // return usuarioService.findByUsuarioAndPassword(usuario, password);
        return ResponseEntity.ok(response);
    }

    @PostMapping(value = "/login", consumes = "application/json;charset=UTF-8", produces = "application/json")
    public ResponseEntity<?> login(@RequestBody String requestData) {
        try {
            // ObjectMapper mapper = new ObjectMapper();UsuarioController
            // Map jsonMap = mapper.readValue(requestData, Map.class);

            Map<String, Object> response = new HashMap<>();
            response.put("success", true);

            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

}
