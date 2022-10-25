package dev.bigstack.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dev.bigstack.components.DIServiceComponent;

@Configuration
public class DIConfig {

    @Bean
    DIServiceComponent diServiceComponent() {
        return new DIServiceComponent();
    }
    
}