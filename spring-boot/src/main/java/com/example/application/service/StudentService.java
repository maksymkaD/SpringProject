package com.example.application.service;

import com.example.application.exceptions.CustomExceptionHandler;
import com.example.application.exceptions.CustomRequestException;
import com.example.application.model.Student;
import com.example.application.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Field Injection
 */
@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final CustomExceptionHandler customExceptionHandler;

    public StudentService(StudentRepository studentRepository, CustomExceptionHandler customExceptionHandler) {
        this.studentRepository = studentRepository;
        this.customExceptionHandler = customExceptionHandler;
    }

    public ResponseEntity<List<Student>> getAllStudents() {
        return new ResponseEntity<>(studentRepository.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<Object> getStudent(long id) {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        /*if (!optionalStudent.isPresent()) {
            return customExceptionHandler.handleException(
                    new CustomRequestException(String.format("Student with id %s was not found", id))
            );
        }*/
        return new ResponseEntity<>(optionalStudent.get(), HttpStatus.OK);

    }

    public void createStudent(Student student) { studentRepository.save(student); }

    public void deleteStudent(Student student) { studentRepository.delete(student); }


}
