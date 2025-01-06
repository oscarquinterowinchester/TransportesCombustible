package com.appchoferes.nomina.shared.security;

import java.io.IOException;
import java.security.Key;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import com.appchoferes.nomina.shared.config.DynamicRoutingDataSource;
import com.appchoferes.nomina.shared.context.UserContext;
import com.appchoferes.nomina.shared.context.UserContextHolder;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private DynamicRoutingDataSource dynamicRoutingDataSource;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private Key jwtKey;

    @Autowired
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {
            
        String header = request.getHeader("Authorization");

        // Verifica si el encabezado Authorization esta presente y es valido
        if (header != null && header.startsWith("Bearer ")) {
            String token = header.substring(7);
            try {
                Jws<Claims> claims = Jwts.parserBuilder()
                        .setSigningKey(jwtKey)
                        .build()
                        .parseClaimsJws(token);

                // Extrae la informacion necesaria del token
                String empresaID = claims.getBody().get("empresa", String.class);

                // Consulta la base de datos para obtener los datos del usuario
                String sqlempresa = "SELECT nombre_db, usuario_db, CAST(AES_DECRYPT(password_db,'integranets01') AS CHAR(100)) AS password_db "
                        +
                        "FROM clientesempresas_tbl WHERE ID = ?";

                Map<String, Object> resultempresa = jdbcTemplate.queryForMap(sqlempresa, empresaID);

                // Extrae los datos necesarios de la consulta
                String dbName = (String) resultempresa.get("nombre_db");
                String dbUser = (String) resultempresa.get("usuario_db");
                String dbPass = (String) resultempresa.get("password_db");
                String dbEmpresa = empresaID;
                String dbNombreUsuario = claims.getBody().get("nombreUsuario", String.class);
                String dbApellidoPaterno = claims.getBody().get("apellidoPaterno", String.class);

                // Verifica si existe el DataSource dinamico para la empresa
                if (!dynamicRoutingDataSource.hasDataSource(dbName)) {
                    response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                    response.setContentType("application/json");
                    response.getWriter().write("{\"error\": \"La sesión ha caducado. Por favor, inicia sesión nuevamente.\"}");
                    return;
                }

                // Establce el contexto del usuario
                UserContextHolder.setUserContext(new UserContext(dbName, dbUser, dbPass, dbEmpresa, dbNombreUsuario, dbApellidoPaterno));

                // Establece la autenticacion en el contexto de Spring Security
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                        claims.getBody().getSubject(), //Username
                        null, // no neceistas credenciales aqui
                        null // Roles o permisos, si los tienes

                );

                SecurityContextHolder.getContext().setAuthentication(authentication);

            } catch (ExpiredJwtException e) {
                // Maneja el caso de token expirado
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                response.setContentType("application/json");
                response.getWriter().write("{\"error\": \"Token inválido o no autorizado.\"}");
                UserContextHolder.clear();
                return;
            } catch (Exception e) {
                // Manejo general de errores de validacion del token
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                response.setContentType("application/json");
                response.getWriter().write("{\"error\": \"Token inválido o no autorizado.\"}");
                UserContextHolder.clear();
                return;

            }

        } else {
            // Si no hay token, limpia el contexto
            UserContextHolder.clear();
        }

        // Continua con el filtro
        try {
            filterChain.doFilter(request, response);
        } finally {
            // Limpia el contexto despues de la solicitud 
            UserContextHolder.clear();
        }

    }

}
