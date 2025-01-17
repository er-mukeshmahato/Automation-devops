package com.banking.api.banking_api.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@Component
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // Allow all origins or you can specify the frontend URL
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:8082")  // Frontend's URL
                .allowedMethods("GET", "POST", "PUT", "DELETE", "PATCH")  // Allow all HTTP methods
                .allowedHeaders("*")  // Allow all headers
                .allowCredentials(true);  // Allow cookies or authentication info
    }
}
 
