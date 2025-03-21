package com.appchoferes.nomina.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.jsonwebtoken.security.Keys;
import java.security.Key;

@Configuration
public class JwtConfig {
    @Bean
    public Key jwtKey() {
        return Keys.hmacShaKeyFor("MiLlaveSecretaDeIntegranetDe256Bits!".getBytes());
    }
}

