package com.example.application.service.user;

import com.example.application.dal.model.User;
import com.example.application.dal.repository.UserRepository;
import com.example.application.dto.user.teacher.TeacherCreate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Field Injection
 */
@Service
public class TeacherService {
    @Autowired
    UserRepository userRepository;

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
}
