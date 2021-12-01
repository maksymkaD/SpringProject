package com.example.application.service;

import com.example.application.dal.model.User;
import com.example.application.dal.repository.UserRepository;
import com.example.application.dto.teacher.TeacherCreate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Field Injection
 */
@Service
public class TeacherService {
    @Autowired
    UserRepository userRepository;

    public List<User> getTeachers() {
        return userRepository.getUsersByRole("teacher");
    }

    public Optional<User> getTeacherById(Integer id) {
        return userRepository.findById(id);
    }

    public void createTeacher(TeacherCreate teacherCreate) {
        User teacher = new User(
                teacherCreate.getEmail(),
                teacherCreate.getPassword(),
                teacherCreate.getName(),
                teacherCreate.getLastName(),
                "teacher",
                teacherCreate.getPosition()
        );

        userRepository.save(teacher);
    }

    public void deleteTeacher(Integer id) {
        userRepository.deleteById(id);
    }
}
