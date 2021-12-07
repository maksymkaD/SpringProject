package com.example.application.service;

import com.example.application.dal.model.User;
import com.example.application.dal.repository.UserRepository;
import com.example.application.dto.teacher.TeacherCreateDTO;
import com.example.application.dto.teacher.TeacherUpdateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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
        Optional<User> teacher = userRepository.findById(id);

        if (!teacher.isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Teacher not found");
        }

        return teacher;
    }

    public void createTeacher(TeacherCreateDTO teacherCreateDTO) {
        User teacher = new User(
                teacherCreateDTO.getEmail(),
                teacherCreateDTO.getPassword(),
                teacherCreateDTO.getName(),
                teacherCreateDTO.getLastName(),
                "teacher",
                teacherCreateDTO.getPosition()
        );

        System.out.println(teacher.getRole());

        userRepository.save(teacher);
    }

    public void updateTeacher(Integer id, TeacherUpdateDTO teacherUpdateDTO) {
        Optional<User> teacher = getTeacherById(id);

        if (!teacher.isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Teacher not found");
        }

        User teacherToUpdate = teacher.get();

        String email = teacherUpdateDTO.getEmail();
        String name = teacherUpdateDTO.getName();
        String password = teacherUpdateDTO.getPassword();
        String lastName = teacherUpdateDTO.getLastName();
        String position = teacherUpdateDTO.getPosition();

        if (!email.isEmpty()) {
            teacherToUpdate.setEmail(email);
        }
        if (!name.isEmpty()) {
            teacherToUpdate.setName(name);
        }
        if (!password.isEmpty()) {
            teacherToUpdate.setPassword(password);
        }
        if (!lastName.isEmpty()) {
            teacherToUpdate.setLastName(lastName);
        }
        if (!position.isEmpty()) {
            teacherToUpdate.setPosition(position);
        }


        userRepository.save(teacherToUpdate);
    }

    public void deleteTeacher(Integer id) {
        userRepository.deleteById(id);
    }
}
