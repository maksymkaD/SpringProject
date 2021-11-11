package com.example.application.controller;

import com.example.application.dto.StudentDTO;
import com.example.application.exceptions.CustomExceptionHandler;
import com.example.application.exceptions.CustomRequestException;
import com.example.application.model.Student;
import com.example.application.service.StudentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<Object> getStudent(@PathVariable("id") long id) {
        Optional<Student> student = studentService.getStudent(id);

        if (!student.isPresent()) {
            CustomExceptionHandler customExceptionHandler = new CustomExceptionHandler();
            return customExceptionHandler.handleException(
                    new CustomRequestException("No student with such id found")
            );
        }
        return new ResponseEntity<>(convertToDto(student.get()), HttpStatus.OK);
    }

    @PostMapping(path = "/students")
    public void createAdmin(@RequestBody Student student){
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
