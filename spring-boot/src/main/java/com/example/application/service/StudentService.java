package com.example.application.service;

import com.example.application.dal.model.User;
import com.example.application.dal.repository.UserRepository;
import com.example.application.dto.student.StudentCreateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public void createStudent(StudentCreateDTO studentDTO) {
        User teacher = new User(
                studentDTO.getEmail(),
                studentDTO.getPassword(),
                studentDTO.getName(),
                studentDTO.getLastName(),
                "student",
                studentDTO.getYear()
        );

        userRepository.save(teacher);
    }

    public void deleteStudent(Integer id) {
        userRepository.deleteById(id);
    }
}
