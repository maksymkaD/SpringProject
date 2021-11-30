package com.example.application;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.*;
import java.sql.*;

@Configuration
@SpringBootApplication
public class Application {
	public static void main(String[] args) throws Exception{
		SpringApplication.run(Application.class, args);
        // Connection connection = DriverManager.getConnection ("jdbc:h2:mem:dev", "dev_name","dev_pass");
		//seedDB(connection);
	}

}



