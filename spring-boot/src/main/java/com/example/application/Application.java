package com.example.application;


import com.example.application.db.DbQueries;
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

		DbQueries dbQueries = new DbQueries(conn);
		//Fill database with data for tests
		st.executeUpdate("INSERT INTO st_groups (subject_id) VALUES (1)");
		st.executeUpdate("INSERT INTO lessons (subject_id, group_id, teacher_id, date, type) " +
				"VALUES (1, 1, 1, '2020-05-01 12:30:00', 'lecture')");
		st.executeUpdate("INSERT INTO students (email, password, last_name, first_name, year_of_study) " +
				"VALUES ('student@ukma.edu.ua','1','Johnson','Petro',4)");
		st.executeUpdate("INSERT INTO teachers (email, password, last_name, first_name, position) " +
				"VALUES ('teacher@ukma.edu.ua','1','McCaine','Dmytro','Professor')");
		st.executeUpdate("INSERT INTO subjects (name, cathedra_name, cathedra_id) VALUES ('Databases','Informatics',10)");

		//Add student with DbQueries
		dbQueries.StudentCreate(new String[]{"first_name", "last_name", "email", "password", "year_of_study"}
				,new String[]{"Jimmy", "Hoffman", "jimmy@ukma.edu.ua","password123","3"});

		dbQueries.StudentUpdate(2,new String[]{"last_name"}, new String[]{"Carlson"});

		conn.close();
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

}



