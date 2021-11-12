package com.example.application.controller;

import com.example.application.model.Student;
import com.example.application.service.StudentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public ResponseEntity<List<Student>>getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/student/{id}")
    public ResponseEntity<Object> getStudent(@PathVariable("id") long id) {
        return studentService.getStudent(id);
    }

    @PostMapping(path = "/students")
    public void createStudent(@RequestBody Student student){
        studentService.createStudent(student);
    }

    @DeleteMapping("/students")
    public void deleteStudent(@RequestBody Student student) {
        studentService.deleteStudent(student);
    }
}
