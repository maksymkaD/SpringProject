package com.example.application.service.user;

import com.example.application.dal.model.User;
import com.example.application.dal.repository.UserRepository;
import com.example.application.dto.user.student.StudentCreate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Field Injection
 */
@Service
public class StudentService {
    @Autowired
    UserRepository userRepository;

    public void createStudent(StudentCreate studentCreate) {
        User student = new User(
                studentCreate.getEmail(),
                studentCreate.getPassword(),
                studentCreate.getName(),
                studentCreate.getLastName(),
                "student",
                studentCreate.getYear()
        );

        userRepository.save(student);
    }
}
