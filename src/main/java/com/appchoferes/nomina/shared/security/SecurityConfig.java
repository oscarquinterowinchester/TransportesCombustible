package com.appchoferes.nomina.shared.security;

import java.net.http.HttpResponse;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import jakarta.security.auth.message.AuthException;
import jakarta.servlet.http.HttpServletResponse;

@Configuration
public class SecurityConfig {
    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    public SecurityConfig(JwtAuthenticationFilter jwtAuthenticationFilter) {
        this.jwtAuthenticationFilter = jwtAuthenticationFilter;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.cors()
                .and()
                .csrf().disable()
                .authorizeRequests()
                .requestMatchers("/auth/**").permitAll() // Permite el acceso a todas las rutas de autenticacion 
                .anyRequest().authenticated() // Protege las demas rutas
                .and()
                .exceptionHandling()
                .authenticationEntryPoint((request, response, authException) -> {
                    response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                    response.getWriter().write("No autorizado: por favor verifica tus credenciales o inicia sesión.");
                })
                .and()
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class); // Registra el filtro

        return http.build();
    }
}
