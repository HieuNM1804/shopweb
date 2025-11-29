package com.ptit.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class EncodingConfig implements WebMvcConfigurer {
    // Spring Boot already registers a CharacterEncodingFilter.
    // Keeping this config class minimal avoids bean name conflicts.
}