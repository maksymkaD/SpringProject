package com.example.application;

import com.example.application.dal.model.User;
import com.example.application.dal.repository.SubjectRepository;
import com.example.application.dal.repository.UserRepository;
import com.example.application.service.user.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.Assert.*;

@DataJpaTest
class RepositoryTests {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private SubjectRepository subjectRepository;

	@Test
	public void injectedComponentsAreNotNull(){
		assertNotNull(userRepository);
		assertNotNull(subjectRepository);
		System.out.println("test 1 : injectedComponentsAreNotNull - success");
	}

	@Test
	public void addUser_findUser(){
		User testUser = new User("test2@user.net","1","Test","Testovich","student",2);
		userRepository.save(testUser);
		assertNotNull(userRepository.getByName("Test"));
		assertNotNull(userRepository.getByEmail("test@user.net"));
		assertNotNull(userRepository.getByLastName("Testovich"));
		System.out.println("test 2 : addUser_findUser - success");
	}

	@Test
	public void addUser_deleteUser(){
		User testUser = new User("test3@user.net","1","Test","Testenko","student",2);
		userRepository.save(testUser);
		userRepository.delete(testUser);
		assertNull(userRepository.getByEmail("test3@user.net"));
		System.out.println("test 3 : addUser_deleteUser - success");
	}

	@Test
	public void addUser_updateUser(){
		User testUser = new User("test4@user.net","1","Test","Testenko","student",2);
		testUser.setName("NotTest");
		userRepository.save(testUser);
		assertFalse(userRepository.getByEmail("test4@user.net").getName().equals("Test"));
		System.out.println("test 4 : addUser_updateUser - success");
	}

}
