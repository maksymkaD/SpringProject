package com.example.application.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("classpath:application.properties")
public class ConfigLoader {

    @Value("${spring.h2.console.path}")
    private String consolePath;

    @Bean
    public String getConsolePath(){
        return consolePath;
    }
}