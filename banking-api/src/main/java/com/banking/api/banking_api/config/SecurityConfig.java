package com.banking.api.banking_api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;



public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth // Start authorization rules
                .requestMatchers("/admin/**").hasAuthority("ROLE_ADMIN") // Only ADMIN role can access /admin/*
                .requestMatchers("/user/**").hasAnyAuthority("ROLE_USER", "ROLE_ADMIN") // USER and ADMIN can access /user/*
                .anyRequest().authenticated() // All other requests require authentication
            ); // Optional: Enable basic authentication for testing

        return http.build();
    }

}
