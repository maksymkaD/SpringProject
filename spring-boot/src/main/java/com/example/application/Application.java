package com.example.application;


import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.*;

@SpringBootApplication
public class Application {

	public static void main(String[] args) throws Exception{

		SpringApplication.run(Application.class, args);
        Connection conn = DriverManager.getConnection ("jdbc:h2:mem:testdb", "sa","sa");
        Statement st = conn.createStatement();
		st.executeUpdate("INSERT INTO st_groups (id) VALUES (100)");
		conn.close();
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

}



