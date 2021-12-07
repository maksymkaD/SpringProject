package com.example.application.service;

import com.example.application.dal.model.User;
import com.example.application.dal.repository.UserRepository;
import com.example.application.dto.student.StudentCreateDTO;
import com.example.application.dto.student.StudentUpdateDTO;
import com.example.application.dto.teacher.TeacherUpdateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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

    public void updateStudent(Integer id, StudentUpdateDTO studentUpdateDTO) {
        Optional<User> student = getStudentById(id);

        if (!student.isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Teacher not found");
        }

        User studentToUpdate = student.get();

        String email = studentUpdateDTO.getEmail();
        String name = studentUpdateDTO.getName();
        String password = studentUpdateDTO.getPassword();
        String lastName = studentUpdateDTO.getLastName();
        Integer year = studentUpdateDTO.getYear();

        if (!email.isEmpty()) {
            studentToUpdate.setEmail(email);
        }
        if (!name.isEmpty()) {
            studentToUpdate.setName(name);
        }
        if (!password.isEmpty()) {
            studentToUpdate.setPassword(password);
        }
        if (!lastName.isEmpty()) {
            studentToUpdate.setLastName(lastName);
        }
        if (year != null) {
            studentToUpdate.setYear(year);
        }


        userRepository.save(studentToUpdate);
    }

    public void deleteStudent(Integer id) {
        userRepository.deleteById(id);
    }
}
