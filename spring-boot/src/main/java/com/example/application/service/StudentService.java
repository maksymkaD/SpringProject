package com.example.application.service;

import com.example.application.dal.model.User;
import com.example.application.dal.repository.UserRepository;
import com.example.application.dto.student.StudentCreate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Field Injection
 */
@Service
public class StudentService {
    @Autowired
    UserRepository userRepository;

    public List<User> getStudents() {
        return userRepository.getUsersByRole("student");
    }

    public Optional<User> getStudentById(Integer id) {
        return userRepository.findById(id);
    }

    public void createStudent(StudentCreate studentCreate) {
        User teacher = new User(
                studentCreate.getEmail(),
                studentCreate.getPassword(),
                studentCreate.getName(),
                studentCreate.getLastName(),
                "student",
                studentCreate.getYear()
        );

        userRepository.save(teacher);
    }

    public void deleteStudent(Integer id) {
        userRepository.deleteById(id);
    }
}
