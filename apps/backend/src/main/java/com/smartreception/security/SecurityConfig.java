package com.smartreception.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable()) // Disable CSRF for non-prod API testing
            .authorizeHttpRequests(auth -> auth
                .requestMatchers(
                    "/api/**", 
                    "/swagger-ui/**", 
                    "/swagger-ui.html", 
                    "/v3/api-docs/**",
                    "/v3/api-docs.yaml"
                ).permitAll()
                .anyRequest().authenticated()
            )
            .httpBasic(org.springframework.security.config.Customizer.withDefaults()); // Keep basic auth for other paths
        
        return http.build();
    }
}
