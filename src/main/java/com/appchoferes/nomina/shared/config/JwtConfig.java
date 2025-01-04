package com.appchoferes.nomina.shared.config;

import java.security.Key;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.jsonwebtoken.security.Keys;

@Configuration
public class JwtConfig {

    @Bean
    public Key jwtKey() {
        return Keys.hmacShaKeyFor("TransportSecretKeyIntegranet256Bits!".getBytes());
    }
}
