package com.anirudh.bookstore.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class DemoSecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/booksApi/**").permitAll() // Allow all access to booksApi
                        .requestMatchers("/authorsApi/**").authenticated() // Require authentication for authorsApi
                        .requestMatchers("/readersApi/readers").permitAll() // Allow access to specific readers endpoint
                        .requestMatchers("/readersApi/**").authenticated() // Require authentication for other readersApi endpoints
                )
                .httpBasic(Customizer.withDefaults());
        return http.build();
    }
}