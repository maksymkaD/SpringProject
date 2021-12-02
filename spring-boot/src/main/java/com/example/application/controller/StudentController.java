package com.example.application.controller;

import com.example.application.model.Student;
import com.example.application.service.StudentService;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Got all students", content = @Content),
            @ApiResponse(responseCode = "404", description = "Not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping("/students")
    public ResponseEntity<List<Student>>getAllStudents() {
        return studentService.getAllStudents();
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Got student", content = @Content),
            @ApiResponse(responseCode = "404", description = "Student not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping("/student/{id}")
    public ResponseEntity<Object> getStudent(@PathVariable("id") long id) {
        return studentService.getStudent(id);
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Student created", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @PostMapping(path = "/students")
    public ResponseEntity<Object> createStudent(@RequestBody Student student){
        return studentService.createStudent(student);
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Student updated"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @PutMapping(path = "/students")
    public ResponseEntity<Object> updateStudent(@RequestBody Student student){
        return studentService.updateStudent(student);
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Student deleted"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @DeleteMapping("/students")
    public void deleteStudent(@RequestBody Student student) {
        studentService.deleteStudent(student);
    }
}
