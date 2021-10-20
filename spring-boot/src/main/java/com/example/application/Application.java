package com.example.application;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;
import org.jboss.logging.MDC;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.*;

@SpringBootApplication
public class Application {
	public static final Logger LOGGER = LogManager.getLogger();
	public static final Marker ADMIN_USER = MarkerManager.getMarker("ADMIN");
	public static final Marker GENERAL_USER = MarkerManager.getMarker("GENERAL");

	public static void main(String[] args) throws Exception{

		SpringApplication.run(Application.class, args);
        Connection conn = DriverManager.getConnection ("jdbc:h2:mem:testdb", "sa","sa");
        Statement st = conn.createStatement();
		st.executeUpdate("INSERT INTO st_groups (id) VALUES (100)");
		MDC.put("request_id", "128");
		MDC.put("application", "runner");
		LOGGER.info("Info level log message");
		LOGGER.debug("Debug level log message");
		LOGGER.error("Error level log message");
		conn.close();
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

}



