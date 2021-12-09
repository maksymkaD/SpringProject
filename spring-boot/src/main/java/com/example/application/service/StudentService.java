package com.example.application.service;

import com.example.application.exceptions.MyResourceNotFoundException;
import com.example.application.exceptions.MyResourceRestrictedException;
import com.example.application.model.Student;
import com.example.application.repository.StudentRepository;
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
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Optional<Student> getStudent(Integer id) {
        Optional<Student> student = studentRepository.findById(id);

        if (!student.isPresent()) {
            throw new MyResourceNotFoundException("Student not found");
        }

        return student;
    }

    public void createStudent(Student student) {
        studentRepository.save(student);
    }

    public void updateStudent(Integer id, Student student) {
        Optional<Student> studentFromDB = getStudent(id);

        if (!studentFromDB.isPresent()) {
            throw new MyResourceNotFoundException("Teacher not found");
        }

        Student studentToUpdate = studentFromDB.get();

        String email = student.getEmail();
        String name = student.getFirstName();
        String password = student.getPassword();
        String lastName = student.getLastName();
        Integer year = student.getYearOfStudy();

        if (!email.isEmpty()) {
            studentToUpdate.setEmail(email);
        }
        if (!name.isEmpty()) {
            studentToUpdate.setFirstName(name);
        }
        if (!password.isEmpty()) {
            studentToUpdate.setPassword(password);
        }
        if (!lastName.isEmpty()) {
            studentToUpdate.setLastName(lastName);
        }
        if (year != null) {
            studentToUpdate.setYearOfStudy(year);
        }


        studentRepository.save(studentToUpdate);
    }

    public void deleteStudent(Integer id) {
        if (id == 1) {
            throw new MyResourceRestrictedException("Student protected from deletion");
        }

        studentRepository.deleteById(id);
    }
}
