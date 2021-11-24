package com.example.application;

import com.example.application.db.DbQueries;
import com.example.application.db.DbQueryException;
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

	private static void seedDB(Connection connection) throws SQLException, DbQueryException {
		Statement st = connection.createStatement();

		DbQueries dbQueries = new DbQueries(connection);

		st.executeUpdate("INSERT INTO st_groups (subject_id) VALUES (1)");
		st.executeUpdate("INSERT INTO lessons (subject_id, group_id, teacher_id, date, type) " +
				"VALUES (1, 1, 1, '2020-05-01 12:30:00', 'lecture')");
		st.executeUpdate("INSERT INTO subjects (name, cathedra_name, cathedra_id) VALUES ('Databases','Informatics',10)");

		//Add student with DbQueries
		dbQueries.StudentCreate(new String[]{"first_name", "last_name", "email", "password", "year_of_study"}
				,new String[]{"Jimmy", "Hoffman", "jimmy@ukma.edu.ua","password123","3"});

		dbQueries.StudentUpdate(2,new String[]{"last_name"}, new String[]{"Carlson"});

		connection.close();
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

}



