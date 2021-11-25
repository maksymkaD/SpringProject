package com.example.application.crud.service;

import com.example.application.crud.dto.TeacherDTO;
import com.example.application.crud.model.User;
import com.example.application.crud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Field Injection
 */
@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public List<User> getUsers(String role) {
        return userRepository.getUsersByRole(role);
    }

    public Optional<User> getUser(int id) {
        return userRepository.findById(id);
    }

    public void createStudent(User user) { userRepository.save(user); }

    public void createTeacher(TeacherDTO teacherDTO) {
        User teacher = new User(teacherDTO.getEmail(), teacherDTO.getPassword(), teacherDTO.getName(),
                "teacher", teacherDTO.getPosition());
        userRepository.save(teacher);
    }

    public void updateUser(User user) { userRepository.save(user); }

    public void deleteUser(int id) { userRepository.deleteById(id); }
}
