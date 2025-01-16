package com.appchoferes.nomina.controllers.lorasdb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.appchoferes.nomina.models.lorasdb.EmpresaModel;
import com.appchoferes.nomina.models.lorasdb.UsuarioModels;
import com.appchoferes.nomina.services.lorasdb.EmpresaService;
import com.appchoferes.nomina.services.lorasdb.UserContext;
import com.appchoferes.nomina.services.lorasdb.UserContextHolder;
import com.appchoferes.nomina.services.lorasdb.UserService;
import com.appchoferes.nomina.services.lorasdb.UsuarioService;

import io.jsonwebtoken.Jwts;
import java.security.Key;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
                List<UsuarioModels> usuarios = usuarioService.findByUsuarioAndPassword(usuario, password);
                if (usuarios.isEmpty()) {
                    return ResponseEntity.badRequest()
                            .body("Error: No se pudo obtener el usuario, consultar a sistemas.");
                }
                // Generar JWT
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
                // response.put("usuario", usuario);
                response.put("usuario", usuarios.isEmpty() ? new UsuarioModels() : usuarios.get(0));
                response.put("empresa", empresa);
                response.put("success", true);
                response.put("accessToken", token);
                // return "Bearer " + token;
                return ResponseEntity.ok(response);
            }
            // return "Error: No se pudo obtener contexto";
            return ResponseEntity.badRequest().body("Error: No se pudo obtener contexto");
        } else {
            // return "Credenciales inválidas.";
            return ResponseEntity.badRequest().body("Credenciales inválidas.");
        }
    }
}
