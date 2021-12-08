package com.example.application;


import com.example.application.cache.ScheduleCacheManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

import static java.util.Arrays.asList;

@Configuration
@SpringBootApplication
@EnableScheduling
@EnableCaching
public class Application {
	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CacheManager cacheManager() {
		ScheduleCacheManager cacheManager = new ScheduleCacheManager();
		cacheManager.setCacheNames(asList("students", "teachers"));
		return cacheManager;
	}

}



