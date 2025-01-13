package com.appchoferes.nomina.auth.controllers;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.appchoferes.nomina.auth.models.EmpresaModel;
import com.appchoferes.nomina.auth.models.UsuarioModel;
import com.appchoferes.nomina.auth.services.EmpresaService;
import com.appchoferes.nomina.auth.services.UserService;
import com.appchoferes.nomina.auth.services.UsuarioService;
import com.appchoferes.nomina.shared.context.UserContext;
import com.appchoferes.nomina.shared.context.UserContextHolder;

import io.jsonwebtoken.Jwts;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private Key jwtKey;

    @Autowired
    private UserService userService;

    @Autowired
    EmpresaService empresaService;

    @Autowired
    UsuarioService usuarioService;

    @GetMapping(value = "/login", produces = "application/json")
    public ResponseEntity<?> login(@RequestParam String usuario, @RequestParam String password) {
        boolean authenticated = userService.authenticateUser(usuario, password);
        if (authenticated) {
            UserContext userContext = UserContextHolder.getUserContext();
            if (userContext != null) {

                List<UsuarioModel> usuarios = usuarioService.findByUsuarioAndPassword(usuario, password);

                if (usuario.isEmpty()) {
                    return ResponseEntity.badRequest()
                            .body("Error: No se pudo obtener el usuario, consultar a sistemas.");
                }

                String token = Jwts.builder()
                        .setSubject(usuario)
                        .claim("dbName", "")
                        .claim("dbUser", "")
                        .claim("dbPass", "")
                        .claim("empresa", userContext.getEmpresa())
                        .claim("nombreUsuario", userContext.getNombreUsuario())
                        .claim("apellidoPaterno", userContext.getApellidoPaterno())
                        .setExpiration(new Date(System.currentTimeMillis() + 600 * 60 * 1000))
                        .signWith(jwtKey)
                        .compact();
                Integer empresaID = Integer.parseInt(userContext.getEmpresa());
                EmpresaModel empresa = empresaService.seleccionarEmpresa(1);
                Map<String, Object> response = new HashMap<>();

                response.put("usuario", usuarios.isEmpty() ? new UsuarioModel() : usuarios.get(0));
                response.put("empresa", empresa);
                response.put("succes", true);
                response.put("accessToken", token);

                return ResponseEntity.ok(response);

            }
            return ResponseEntity.badRequest().body("Error: No se pudo obtener contexto");

        } else {

            return ResponseEntity.badRequest().body("Credenciales invalidas");
        }

    }

}
