package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                // Autoriser le frontend Angular qui tourne sur localhost:4200
                registry.addMapping("/api/**")  // Applique uniquement sur les routes API
                        .allowedOrigins("http://localhost:4200")  // Frontend Angular
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")  // Méthodes HTTP autorisées
                        .allowedHeaders("*")  // En-têtes autorisés
                        .allowCredentials(true);  // Autorise les cookies et l'authentification
            }
        };
    }
}
