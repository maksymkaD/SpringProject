package com.example.application.controller;

import com.example.application.exceptions.MyResourceNotFoundException;
import com.example.application.exceptions.MyResourceRestrictedException;
import com.example.application.model.Student;
import com.example.application.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Validated
@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/students/{id}")
    public Optional<Student> getStudent(@PathVariable("id") Integer id) {

        return studentService.getStudent(id);
    }

    @PostMapping(path = "/students")
    public void createAdmin(@Valid @RequestBody Student student) {
        studentService.createStudent(student);
    }

    @PutMapping(path = "/students/{id}")
    public void createAdmin(@PathVariable("id") Integer id, @Valid @RequestBody Student student) {
        studentService.updateStudent(id, student);
    }

    @DeleteMapping("/students/{id}")
    public void deleteStudent(@PathVariable("id") Integer id) {
        studentService.deleteStudent(id);
    }

    @ExceptionHandler(MyResourceNotFoundException.class)
    public ResponseEntity<Object> handleMyResourceNotFoundException(MyResourceNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MyResourceRestrictedException.class)
    public ResponseEntity<Object> handleMyResourceRestrictedException(MyResourceRestrictedException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
}
