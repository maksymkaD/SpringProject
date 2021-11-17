package com.example.application.controller;

import com.example.application.dto.StudentDTO;
import com.example.application.model.Student;
import com.example.application.service.StudentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Field Injection
 */
@Validated
@RestController
public class StudentController {
    @Autowired
    ModelMapper modelMapper;

    @Autowired
    private StudentService studentService;

    @GetMapping("/students")
    public List<StudentDTO> getAllStudents() {
        List<Student> students = studentService.getAllStudents();
        return students.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/student/{id}")
    public StudentDTO getStudent(@PathVariable("id") long id) {
        Optional<Student> student = studentService.getStudent(id);

        return convertToDto(student.get());
    }

    @PostMapping(path = "/students")
    public void createStudent(@RequestBody Student student){
        studentService.createStudent(student);
    }

    @DeleteMapping("/students")
    public void deleteStudent(@RequestBody Student student) {
        studentService.deleteStudent(student);
    }

    private StudentDTO convertToDto(@Valid  Student student) {
        return modelMapper.map(student, StudentDTO.class);
    }
}
